public boolean canTransform(String start, String end) {
	// First, remove all 'X', and compare if they equal.
	StringBuffer s = new StringBuffer();
	StringBuffer e = new StringBuffer();
	for (char c : start.toCharArray()) {
		if (c != 'X') {
			s.append(c);
		}
	}
	for (char c : end.toCharArray()) {
		if (c != 'X') {
			e.append(c);
		}
	}
	if (!s.toString().equals(e.toString()))
		return false;
	// check R
	// form i to start.length(), 
	// if R found in start count++, 
	// if R found in end count--, 
	// if count comes to negative, that means 'R' is in more left position in end, so 'R' can't move from start to end.
	int count = 0;
	for (int i = 0; i < start.length(); i++) {
		if (start.charAt(i) == 'R') {
			count++;
		}
		else if (end.charAt(i) == 'R') {
			count--;
		}
		if (count < 0) {
			return false;
		}
	}
	// check L
	// same with checking 'R', only difference is: 
	// to ensure every 'L' comes first in end.
	count = 0;
	for (int i = 0; i < start.length(); i++) {
		if (end.charAt(i) == 'L') {
			count++;
		}
		else if (start.charAt(i) == 'L') {
			count--;
		}
		if (count < 0) {
			return false;
		}
	}
	return true;
}
