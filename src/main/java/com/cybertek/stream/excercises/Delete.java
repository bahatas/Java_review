package com.cybertek.stream.excercises;

public class Delete {

  /*

   ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain
    anything but exactly 4 digits or exactly 6 digits.

If the function is passed a valid PIN string, return true, else return false.
"1234"   -->  true
            "12345"  -->  false
            "a234"   -->  false
   */

    /*
    //pattern to find if there is any special character in string
Pattern regex = Pattern.compile("[$&+,:;=?@#|'<>.-^*()%!]");
//matcher to find if there is any special character in string
Matcher matcher = regex.matcher(searchQuery.getSearchFor());

if(matcher.find())
{
    errors.rejectValue("searchFor", "wrong_pattern.SearchQuery.searchForSpecialCharacters","Special characters are not allowed!");
}
     */
    public static boolean validatePin(String pin) {
        boolean result=false;
        if (pin.length() == 6 || pin.length() == 4) {

            for (int i = 0; i < pin.length(); i++) {
                if (!Character.isDigit(pin.charAt(i))) {
                   result=false;
                } else
                    result= true;
            }
        } else {
            result= false;
        }

        return result;
    }


//    /super cozum
//     return pin.matches("[0-9]{4}|[0-9]{6}");

 //    if (pin.matches("\\d{4}|\\d{6}")) {

//    Pattern pattern = Pattern.compile("^([0-9]{4}|[0-9]{6})$");
//    Matcher match = pattern.matcher(pin);
//    if(match.matches()) return true;
//    else return false;

//    return (pin.length() == 4 || pin.length() == 6) && pin.replaceAll("[0-9]","").length() == 0;
    public static void main(String[] args) {
        System.out.println("validatePin(\"12345\") = " + validatePin("12345"));
        System.out.println("validatePin(\"a12a\") = " + validatePin("a12a"));
        System.out.println("validatePin(\"a12a\") = " + validatePin("1234"));
    }
}
