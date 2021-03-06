package com.burgess.excel.handler.style;

/**
 * @project banana-excel
 * @package com.burgess.excel.handler.style
 * @file Style.java
 * @author burgess.zhang
 * @time 22:27:50/2018-08-28
 * @desc
 */
public class Style {
	public final static class ColumnWidth {
		public final static String name = "ColumnWidth";

	}

	public final static class Format {
		public final static String name = "Format";

		public final static class Value {
			public final static String DefaultDateFormt = "yyyy-MM-dd HH:mm:SS";

		}
	}

	public final static class FontBoldweight {
		public final static String name = "FontBoldweight";

		public final static class Value {
			/**
			 * Normal boldness (not bold)
			 */

			public final static short BOLDWEIGHT_NORMAL = 0x190;

			/**
			 * Bold boldness (bold)
			 */

			public final static short BOLDWEIGHT_BOLD = 0x2bc;
		}
	}

	public final static class WrapText {
		public final static String name = "WrapText";

		public final static class Value {
			public final static Boolean WrapText_True = true;
			public final static Boolean WrapText_False = false;
		}
	}

	public final static class FontHeightInPoints {
		public final static String name = "FontHeightInPoints";
	}

	public final static class Alignment {
		public final static String name = "Alignment";

		public final static class Location {
			public final static String ALIGN_GENERAL = "ALIGN_GENERAL";
			public final static String ALIGN_RIGHT = "ALIGN_RIGHT";
			public final static String ALIGN_CENTER = "ALIGN_CENTER";
			public final static String ALIGN_LEFT = "ALIGN_LEFT";
		}

		public final static class Value {
			/**
			 * general (normal) horizontal alignment
			 */

			public final static short ALIGN_GENERAL = 0x0;

			/**
			 * left-justified horizontal alignment
			 */

			public final static short ALIGN_LEFT = 0x1;

			/**
			 * center horizontal alignment
			 */

			public final static short ALIGN_CENTER = 0x2;

			/**
			 * right-justified horizontal alignment
			 */

			public final static short ALIGN_RIGHT = 0x3;

			/**
			 * fill? horizontal alignment
			 */

			public final static short ALIGN_FILL = 0x4;

			/**
			 * justified horizontal alignment
			 */

			public final static short ALIGN_JUSTIFY = 0x5;

			/**
			 * center-selection? horizontal alignment
			 */

			public final static short ALIGN_CENTER_SELECTION = 0x6;
		}

	}

	public final static class ForeGroundColor {
		public final static String name = "ForeGroundColor";

		public final static class Value {
			/** Solidly filled */
			public final static short SOLID_FOREGROUND = 1;

			/** Small fine dots */
			public final static short FINE_DOTS = 2;

			/** Wide dots */
			public final static short ALT_BARS = 3;

			/** Sparse dots */
			public final static short SPARSE_DOTS = 4;

			/** Thick horizontal bands */
			public final static short THICK_HORZ_BANDS = 5;

			/** Thick vertical bands */
			public final static short THICK_VERT_BANDS = 6;

			/** Thick backward facing diagonals */
			public final static short THICK_BACKWARD_DIAG = 7;

			/** Thick forward facing diagonals */
			public final static short THICK_FORWARD_DIAG = 8;

			/** Large spots */
			public final static short BIG_SPOTS = 9;

			/** Brick-like layout */
			public final static short BRICKS = 10;

			/** Thin horizontal bands */
			public final static short THIN_HORZ_BANDS = 11;

			/** Thin vertical bands */
			public final static short THIN_VERT_BANDS = 12;

			/** Thin backward diagonal */
			public final static short THIN_BACKWARD_DIAG = 13;

			/** Thin forward diagonal */
			public final static short THIN_FORWARD_DIAG = 14;

			/** Squares */
			public final static short SQUARES = 15;
			/** Diamonds */
			public final static short DIAMONDS = 16;
			/** Less Dots */
			public final static short LESS_DOTS = 17;
			/** Least Dots */
			public final static short LEAST_DOTS = 18;
		}
	}

	public final static class FontName {
		public final static String name = "FontName";

		public final static class Value {
			public final static String HEI_ti = "黑体";
			public final static String fangsong = "仿宋";
		}
	}

	public final static class Border {
		public final static String name = "Border";

		public final static class Location {
			public final static String BOTTOM = "BOTTOM";
			public final static String LEFT = "LEFT";
			public final static String TOP = "TOP";
			public final static String RIGHT = "RIGHT";
		}

		public final static class Value {
			/**
			 * No border
			 */
			public final static short BORDER_NONE = 0x0;

			/**
			 * Thin border
			 */

			public final static short BORDER_THIN = 0x1;

			/**
			 * Medium border
			 */

			public final static short BORDER_MEDIUM = 0x2;

			/**
			 * dash border
			 */

			public final static short BORDER_DASHED = 0x3;

			/**
			 * dot border
			 */

			public final static short BORDER_HAIR = 0x7;

			/**
			 * Thick border
			 */

			public final static short BORDER_THICK = 0x5;

			/**
			 * double-line border
			 */

			public final static short BORDER_DOUBLE = 0x6;

			/**
			 * hair-line border
			 */

			public final static short BORDER_DOTTED = 0x4;

			/**
			 * Medium dashed border
			 */

			public final static short BORDER_MEDIUM_DASHED = 0x8;

			/**
			 * dash-dot border
			 */

			public final static short BORDER_DASH_DOT = 0x9;

			/**
			 * medium dash-dot border
			 */

			public final static short BORDER_MEDIUM_DASH_DOT = 0xA;

			/**
			 * dash-dot-dot border
			 */

			public final static short BORDER_DASH_DOT_DOT = 0xB;

			/**
			 * medium dash-dot-dot border
			 */

			public final static short BORDER_MEDIUM_DASH_DOT_DOT = 0xC;

			/**
			 * slanted dash-dot border
			 */

			public final static short BORDER_SLANTED_DASH_DOT = 0xD;
		}
	}
}
