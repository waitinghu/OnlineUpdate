package com.seuic.onlineupdate;

import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

public class DownloadXMLParser {

	public static AppUpdate parse(InputStream inputStream) {
		AppUpdate update = null;
		// 获得XmlPullParser解析器
		XmlPullParser xmlParser = Xml.newPullParser();
		try {
			xmlParser.setInput(inputStream, "UTF-8");
			// 获得解析到的事件类别，这里有开始文档，结束文档，开始标签，结束标签，文本等等事件。
			int evtType = xmlParser.getEventType();
			// 一直循环，直到文档结束
			while (evtType != XmlPullParser.END_DOCUMENT) {
				String tag = xmlParser.getName();
				switch (evtType) {
				case XmlPullParser.START_TAG:
					// 通知信息
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
