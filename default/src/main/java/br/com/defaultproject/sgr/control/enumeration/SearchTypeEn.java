package br.com.defaultproject.sgr.control.enumeration;

public enum SearchTypeEn {

	BEGIN {
		@Override
		public String toString() {
			return "1";
		}
	},

	BETWEEN {
		@Override
		public String toString() {
			return "2";
		}
	},

	END {
		@Override
		public String toString() {
			return "3";
		}
	},

}