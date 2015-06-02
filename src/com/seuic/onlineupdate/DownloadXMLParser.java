package com.seuic.onlineupdate;

import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

public class DownloadXMLParser {

	public static AppUpdate parse(InputStream inputStream) {
		AppUpdate update = null;
		// ���XmlPullParser������
		XmlPullParser xmlParser = Xml.newPullParser();
		try {
			xmlParser.setInput(inputStream, "UTF-8");
			// ��ý��������¼���������п�ʼ�ĵ��������ĵ�����ʼ��ǩ��������ǩ���ı��ȵ��¼���
			int evtType = xmlParser.getEventType();
			// һֱѭ����ֱ���ĵ�����
			while (evtType != XmlPullParser.END_DOCUMENT) {
				String tag = xmlParser.getName();
				switch (evtType) {
				case XmlPullParser.START_TAG:
					// ֪ͨ��Ϣ
					if (tag.equalsIgnoreCase("android")) {
						update = new AppUpdate();
					} else if (update != null) {
						if (tag.equalsIgnoreCase("versionCode")) {
							update.setVersionCode(Integer.parseInt(xmlParser.nextText()));
						} else if (tag.equalsIgnoreCase("versionName")) {
							update.setVersionName(xmlParser.nextText());
						} else if (tag.equalsIgnoreCase("downloadUrl")) {
							update.setDownloadUrl(xmlParser.nextText());
						} else if (tag.equalsIgnoreCase("updateLog")) {
							update.setUpdateLog(xmlParser.nextText());
						}
					}
					break;
				case XmlPullParser.END_TAG:
					break;
				}
				evtType = xmlParser.next();
			}
		} catch (Exception e) {

		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return update;
	}
}
