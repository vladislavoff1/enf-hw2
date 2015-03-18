class ParseException extends Exception {

	public ParseException(String msg) {
		super("Can't parse `" + msg + "`.");
	}

}