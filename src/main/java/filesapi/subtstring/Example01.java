package filesapi.subtstring;

import org.apache.commons.lang3.StringUtils;

public class Example01 {
  private static final String text = "Julia Evans was born on 25-09-1984. "
          + "She is currently living in the USA (United States of America).";

  private static final String text1 = "bkasf sa fasf a<SimpleBean><x>1</x><y>2</y><y>3</y></SimpleBean> afakjs fasfj askjdf ";

  public static void main(String... args) {
    String value1 = StringUtils.substringBetween(text, "(", ")");
    System.out.println("value1 = " + value1);

    String value2 = StringUtils.substringBetween(text1, "<SimpleBean>", "</SimpleBean>");
    System.out.println("value2 = " + value2);

    String value3 = StringUtils.substringBetween(text1, "<SimpleBean>", "</SimpleBean>");
    System.out.println("value3 = " + "<SimpleBean>"+value3+"</SimpleBean>");
  }
}
