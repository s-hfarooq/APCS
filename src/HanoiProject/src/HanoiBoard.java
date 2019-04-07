// Hassan Farooq P.5
// March 19, 2019
// HanoiBoard project
// HanoiBoard
//

import java.util.ArrayList;

public class HanoiBoard {
	private ArrayList<String>[] stacks;
	private int size;

	public HanoiBoard(int newSize) {
		newSize = newSize < 1 ? 1 : newSize;
		newSize = newSize > 9 ? 9 : newSize;

		size = newSize;
		stacks = new ArrayList[3];
		stacks[0] = new ArrayList<String>();
		stacks[1] = new ArrayList<String>();
		stacks[2] = new ArrayList<String>();

		String temp = "";

		for(int i = size; i > 0; i--) {
			for(int j = 0; j < i; j++)
				temp += i + "";
			stacks[0].add(temp);
			temp = "";
		}

		for(int i = 0; i < size; i++) {
			stacks[1].add("-");
			stacks[2].add("-");
		}
	}

	public boolean move(int from, int to) {
		boolean isValid = true;

		int oldIndex = stacks[from].indexOf("-") - 1;
		if(oldIndex == -2)
			oldIndex = size - 1;

		if(oldIndex > -1) {
			int newIndex = stacks[to].indexOf("-");

			if(newIndex == 0 || stacks[from].get(oldIndex).length() <= stacks[to].get(newIndex - 1).length()) {
				stacks[to].set(newIndex, stacks[from].get(oldIndex));
				stacks[from].set(oldIndex, "-");
			} else {
				System.out.println("Value of `from` larger than current value at `to`");
				isValid = false;
			}
		} else {
			System.out.println("No values at `from` position");
			isValid = false;
		}

		return isValid;
	}

	public boolean compPlay(int i, int from, int to, int extra) {
		if(i == 1) {
			move(from, to);
			return true;
		}

		compPlay(i - 1, from, extra, to);
		System.out.println(this);
		move(from, to);
		System.out.println(this);
		compPlay(i - 1, extra, to, from);
		return false;
	}

	private String rowToString(int index, int row) {
		String output = "";

		for(int i = 0; i < 9 - stacks[index].get(stacks[index].size() - 1 - row).length() + 1; i++)
			output += " ";
		output += stacks[index].get(stacks[index].size() - 1 - row);

		return output;
	}

	public String toString() {
		String output = "";

		for(int i = 0; i < size; i++) {
			for(int j = 0; j < 3; j++)
				output += rowToString(j, i);
			output += "\n";
		}
		
		return output;
	}
}
