package test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class XMLParser {

	ArrayList<EpgChannel> chnls;
	ArrayList<Document> files;

	public XMLParser() {
		this.chnls = new ArrayList<>();
		this.files = loadFiles("C:\\Users\\JSK\\Desktop\\EPG1");
		this.createEpg(files);
	}

	public static Document loadFile(String str) {
		File fXmlFile = new File(str);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		return doc;
	}

	public static <T> T[] concatenate(T[] a, T[] b) {
		int aLen = a.length;
		int bLen = b.length;
		@SuppressWarnings("unchecked")
		T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);
		return c;
	}

	// 한 폴더 안에 여러 EPG 데이터 가능
	public static ArrayList<Document> loadFiles(String addr) {

		File file = new File(addr);
		// 미완
		// 만약 arr[]이 디렉토리라면 한번더 listFiles()한다. 맨마지막까지 들어가서 파일이 나온다면 ArrayList에 추가한다.
		File arr[] = file.listFiles();
		File sum[] = new File[11000];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].isDirectory()) {
				File temp[] = arr[i].listFiles();
				sum = concatenate(sum, temp);
			}
		}

		ArrayList<Document> doc = new ArrayList<>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		Document element = null;
		for (int i = 0; i < sum.length; i++) {
			if (sum[i] == null) {
				continue;
			} else {
				try {
					dBuilder = dbFactory.newDocumentBuilder();
					element = dBuilder.parse(sum[i]);
				} catch (ParserConfigurationException | SAXException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				element.getDocumentElement().normalize();
				doc.add(element);
			}
		}
		// System.out.println(doc.size());
		return doc;
	}

	public void createEpg(ArrayList<Document> input) {

		Document doc = null;
		ArrayList<EpgChannel> results = new ArrayList<>();
		EpgChannel result = null;

		for (int index = 0; index < input.size(); index++) {

			try {
				doc = input.get(index);
				result = new EpgChannel();
				result.programs = new ArrayList<Program>();
				result.period = new Period();

				// System.out.println("Root element :" +
				// doc.getDocumentElement().getNodeName());
				NodeList first = doc.getElementsByTagName("ScheduleProvider");
				Element element = (Element) first.item(0);
				result.channelName=element.getAttribute("name");
			
				NodeList downloads = doc.getElementsByTagName("DownloadPeriod");
				Element download = (Element) downloads.item(0);
				// System.out.println("DownloadPeriod serviceRef : " +
				// download.getAttribute("serviceRef"));
				result.serviceRef = download.getAttribute("serviceRef");
				NodeList periods = doc.getElementsByTagName("Period");
				NodeList programs = doc.getElementsByTagName("Programme");

				Element epgPeriod = (Element) periods.item(0);

				result.period.start = epgPeriod.getAttribute("start");
				result.period.end = epgPeriod.getAttribute("end");
				// System.out.println("Schedule starts : " + result.period.start);
				// System.out.println("Schedule ends : " + result.period.end);
				// System.out.println("Programmes Length: " + programs.getLength());
				for (int i = 0; i < programs.getLength(); i++) {
					// System.out.println("---------------------------------------------");
					Element program = (Element) programs.item(i);
					Element period = (Element) periods.item(i + 1);
					String start = period.getAttribute("start");
					String end = period.getAttribute("end");

					Program prg = new Program();
					prg.id = program.getAttribute("id");
					prg.desc = new EpgDescription();

					prg.period = new Period();
					prg.period.start = start;
					prg.period.end = end;

					// System.out.println("Start : " + prg.period.start);
					// System.out.println("End : " + prg.period.end);

					String action = program.getAttribute("action");
					prg.action = action;

					// System.out.println("Action : " + action);

					if (action.equals("delete")) {

					} else if (action.equals("insert")) {
						if (program.hasChildNodes()) {

							NodeList childs = program.getChildNodes();

							for (int j = 0; j < childs.getLength(); j++) {

								if (childs.item(j).getNodeName().equals("#text")) {
									// 거른다
								} else {
									Node child = childs.item(j);
									if (child.hasChildNodes()) {
										NodeList grandChilds = child.getChildNodes();
										for (int k = 0; k < grandChilds.getLength(); k++) {
											if (grandChilds.item(k).getNodeName().equals("#text")) {
												// 거른다
											} else {

												// System.out.println();
												// System.out.println(grandChilds.item(k).getNodeName()); // EpgElement
												// System.out.println(grandChilds.item(k).getAttributes()
												// .getNamedItem("key").getNodeValue()); // DVB_Content,
												// // Parental_Rating,
												// // Directors,
												// // Actors, Title,
												// // Description
												// System.out.println(grandChilds.item(k).getTextContent()); // 내용

												String key = grandChilds.item(k).getAttributes().getNamedItem("key")
														.getNodeValue();

												switch (key) {
												case "DVB_Content":
													prg.desc.DVB_Content = grandChilds.item(k).getTextContent();
													break;
												case "Parental_Rating":
													prg.desc.Parental_Rating = grandChilds.item(k).getTextContent();
													break;
												case "Directors":
													prg.desc.Directors = grandChilds.item(k).getTextContent();
													break;
												case "Actors":
													prg.desc.Actors = grandChilds.item(k).getTextContent();
													break;
												case "Title":
													prg.desc.title = grandChilds.item(k).getTextContent();
													break;
												case "Description":
													prg.desc.Description = grandChilds.item(k).getTextContent();
													break;
												}

											}
										}
									} else {

									}
								}

							}
						}
					}

					result.programs.add(i, prg);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.chnls.add(index, result);
		}

	}

}
