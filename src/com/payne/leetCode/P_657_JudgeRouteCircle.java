package com.payne.leetCode;

/**
 * Created by payne on 2018-01-07.
 * About 类描述：
 * Initially, there is a Robot at position (0, 0).
 * Given a sequence of its moves, judge if this robot makes a circle,
 * which means it moves back to the original place.

 The move sequence is represented by a string. And each move is represent by a character.
 The valid robot moves are R (Right), L (Left), U (Up) and D (down).
 The output should be true or false representing whether the robot makes a circle.
 */
public class P_657_JudgeRouteCircle {
	public boolean judgeCircle(String moves) {
		return my(moves);
	}

	public boolean my(String moves) {
		if (moves == null || moves.length() == 0) {
			return true;
		}
		int rl = 0;
		int ud = 0;
		for (int i = 0; i < moves.length(); i++) {
			switch (moves.charAt(i)) {
				case 'R':
					rl++;
					break;
				case 'L':
					rl--;
					break;
				case 'U':
					ud++;
					break;
				case 'D':
					ud--;
					break;
			}
		}
		return rl == 0 && ud == 0;
	}
}
