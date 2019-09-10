import java.util.ArrayList;
import java.util.Arrays;

public class Date implements Comparable<Date> {

    // class attributes
    protected int day;
    protected int month;
    protected int year;

    // default date constructor (01-01-1970)
    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 1970;
        System.out.println("Date: the default date is: " + this.toString());
    }

    // constructor for specific date
    public Date(int day, int month, int year) {
        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
    }

    // constructor for specific date string input with pattern "dd-mm-yyyy"
    public Date(String strDate) {
        Date parsedDate = parseDate(strDate);
        this.setYear(parsedDate.year);
        this.setMonth(parsedDate.month);
        this.setDay(parsedDate.day);
    }

    // setters
    public void setDay(int day) {
        if (isValidDay(day))
            this.day = day;
        else
            System.err.println("Date: invalid day!");
    }

    public void setMonth(int month) {
        if (isValidMonth(month))
            this.month = month;
        else
            System.err.println("Date: invalid month!");
    }

    public void setYear(int year) {
        if (isValidYear(year))
            this.year = year;
        else
            System.err.println("Date: invalid year!");
    }

    // getters
    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    // diffrence method
    // TODO...

    // add-days method
    // TODO...

    // add-months method
    // TODO...
    
    // add-years method
    // TODO...

    // toString method to pattern "dd-mm-yyyy"
    @Override
    public String toString() {
        String output = "";
        String formatedDay = String.format("%02d", this.day);
        String formatedMonth = String.format("%02d", this.month);
        String formatedYear = String.format("%04d", this.year);
        output = formatedDay + "-" + formatedMonth + "-" + formatedYear;
        return output;
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Date))
            return false;

        Date another = (Date) obj;
        if (this.day != another.day || this.month != another.month || this.year != another.year) {
            return false;
        }
        return true;
    }

    // compareTo method
    @Override
    public int compareTo(Date another) {
        if (this.year > another.year)
            return 1;
        if (this.year < another.year)
            return -1;

        if (this.month > another.month)
            return 1;
        if (this.month < another.month)
            return -1;

        if (this.day > another.day)
            return 1;
        if (this.day < another.day)
            return -1;

        return 0;
    }

    // ===============================
    // validation methods://

    // validate day method
    private boolean isValidDay(int day) {
        if (day < 1 || day > maxDaysOfMonth(this.month))
            return false;

        return true;
    }

    // validate month method
    private static boolean isValidMonth(int month) {
        if (month < 1 || month > 12) {
            return false;
        }
        return true;
    }

    // validate year method
    private static boolean isValidYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        }
        return true;
    }

    // ==========================
    // utils methods

    // return max days of a month
    private int maxDaysOfMonth(int month) {
        ArrayList<Integer> monthsWith31Days = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
        ArrayList<Integer> monthsWith30Days = new ArrayList<Integer>(Arrays.asList(4, 6, 9, 11));

        if (monthsWith31Days.contains(month))
            return 31;

        if (monthsWith30Days.contains(month))
            return 30;

        if (month == 2)
            if (isLeapYear(this.year))
                return 29;
            else
                return 28;

        // if invalid
        System.err.println("Date: invalid month!");
        return -1;
    }

    // return true if year is leap
    private static boolean isLeapYear(int year) {
        // check if year is leap
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 4 == 0) && (year % 400 == 0))
            return true;

        return false;
    }

    // parse date with pattern "dd-mm-yyyy"
    private static Date parseDate(String ddmmyyyy) {
        String[] splitedStrDate = ddmmyyyy.split("-");

        // check if pattern is not valid
        if (splitedStrDate.length != 3) {
            System.err.println("Date: invalid date pattern!");
            return new Date();
        }

        int day = Integer.parseInt(splitedStrDate[0]);
        int month = Integer.parseInt(splitedStrDate[1]);
        int year = Integer.parseInt(splitedStrDate[2]);
        return new Date(day, month, year);
    }

}