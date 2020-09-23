package Programmers;

import java.util.*;

public class SkillTree {

	SkillTree() {

	}

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

		SkillTree st = new SkillTree();
		int answer = st.solution(skill, skill_trees);

		System.out.println(answer);
		
	}

	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		String filter = "[^" + skill + "]";
		
		for (String st : skill_trees) {
			String core = st.replaceAll(filter, "");
			String match = skill.substring(0, core.length());
			
			if (match.equals(core)) {
				answer++;
			}
		}
		return answer;
	}

}
