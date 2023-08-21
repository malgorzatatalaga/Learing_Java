package learn.strings;

public class UsingStrings {
    static String pool = "hello";
    public static void main(String[] args) {
        String string = new String("hello");
        System.out.println(pool == string);

        //1. intern()
        /*
        When the intern method is invoked, if the pool already contains a string equal to this String object
        as determined by the equals(Object) method, then the string from the pool is returned.
        Otherwise, this String object is added to the pool and a reference to this String object is returned.
         */
        string = string.intern();
        System.out.println(pool == string);

        //2. replaceAll()
        String whiteSpace = "     8764     898";
        /*
        //s - denotes whitespace characters
         */
        System.out.println("Removing all whitespaces: " + whiteSpace.replaceAll("\\s+", ""));

        String xss = "<script>alert</script>";
        /*
        ? - may or may not appear
         */
        System.out.println(xss.replaceAll("</?script>", ""));

        //3. format()
        String str1 = String.format("I like %.3s%nThey are %2.3f/10", "cats", 10.987988);
        /*
        %n - new line
        %.3 - the length of the string
        %2.3f - number of characters before or after the period
         */
        System.out.println(str1);

        //4. join()
        String str2 = String.join("; ", new String[] {"cats", "dogs", "kittens"});
        System.out.println(str2);
    }
}
