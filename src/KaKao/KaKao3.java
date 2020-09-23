package KaKao;

import java.util.*;

public class KaKao3 {

	public KaKao3() {

	}

	public static void main(String[] args) {

		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		KaKao3 k3 = new KaKao3();
		int[] answer = k3.solution(info, query);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public int[] solution(String[] info, String[] query) {
		int[] answer = {};
		Info infos = new Info(info);
		Query querys = new Query(query);

		infos.parseInfo();
		querys.parseQuery();

		answer = infos.query(querys.parsedQuery);
		return answer;
	}

	class Info {
		String[] rawInfo;
		ArrayList<Map> parsedInfo;

		public Info(String[] rawInfo) {
			this.rawInfo = rawInfo;
		}

		public void parseInfo() {
			ArrayList<Map> ret = new ArrayList<>();
			for (int i = 0; i < rawInfo.length; i++) {

				Map<String, Integer> map = new HashMap<>();

				String[] strs = rawInfo[i].split(" ");
				int score = Integer.parseInt(strs[strs.length - 1]);
				String con = "";
				for (int j = 0; j < strs.length - 1; j++) {
					con += strs[j];
				}

				map.put(con, score);
				ret.add(map);
			}

			this.parsedInfo = ret;
		}

		public int[] query(ArrayList<String[]> querys) {
			int[] ret = new int[querys.size()];
			int idx = 0;
			for (String[] query : querys) {

				String lang = (query[0].contains("-")) ? "" : query[0];
				String part = (query[1].contains("-")) ? "" : query[1];
				String his = (query[2].contains("-")) ? "" : query[2];
				String food = (query[3].contains("-")) ? "" : query[3];
				String score = (query[4].contains("-")) ? "" : query[4];

				ret[idx] = search(lang, part, his, food, score);
				System.out.println(idx + " th query result = " + ret[idx]);
				idx++;
			}

			return ret;
		}

		public int search(String lang, String part, String his, String food, String score) {
			int num = 0;

			for (Map<String, Integer> map : parsedInfo) {
				int match = 0;
				for (String info : map.keySet()) {
					System.out.println("info = " + info);
					System.out.printf("lang = %s, part = %s, his = %s, food = %s, score = %s", lang, part, his, food,
							score);
					System.out.println();
					if (info.contains(lang)) {
						System.out.println("lang match");
						match++;
					} else {
						break;
					}
					if (info.contains(part)) {
						System.out.println("part match");
						match++;
					} else {
						break;
					}
					if (info.contains(his)) {
						System.out.println("his match");
						match++;
					} else {
						break;
					}
					if (info.contains(food)) {
						System.out.println("food match");
						match++;
					} else {
						break;
					}
					if (score.equals("")) {
						match++;
						break;
					} else {
						if (Integer.parseInt(score) >= map.get(info)) {
							System.out.println("score match");
							match++;
						} else {
							break;
						}
					}
					if (match == 5) {
						System.out.println("all matched");
						num++;
						System.out.println("num = " + num);
					}

					System.out.println();
					System.out.println();
					System.out.println();
				}
			}
			return num;
		}
	}

	class Query {
		String[] rawQuery;
		ArrayList<String[]> parsedQuery;

		public Query(String[] rawQuery) {
			this.rawQuery = rawQuery;
			this.parsedQuery = new ArrayList<>();
		}

		public void parseQuery() {
			for (int i = 0; i < rawQuery.length; i++) {
				String numFilter = "[^0-9]";
				String restFilter = "[0-9]";
				String num = rawQuery[i].replaceAll(numFilter, "");

				String rest = rawQuery[i].replaceAll(restFilter, "");
				String trimed = rest.replaceAll(" ", "");
				String[] tokens = trimed.split("and");

				String[] q = new String[tokens.length + 1];
				q[q.length - 1] = num;

				for (int j = 0; j < tokens.length; j++) {
					q[j] = tokens[j];
				}

				this.parsedQuery.add(q);
			}
		}
	}
}
