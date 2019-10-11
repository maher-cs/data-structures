import java.util.ArrayList;
import java.util.Arrays;

public class Date implements Comparable<Date> {

    // CONSTANTS
    private final int START_DATE_DAY = 1;
    private final int START_DATE_MONTH = 1;
    private final int START_DATE_YEAR = 1970;
    

    // class attributes
    protected int day;
    protected int month;
    protected int year;

    // default date constructor
    public Date() {
        this.setDayMonthYear(START_DATE_DAY, START_DATE_MONTH, START_DATE_YEAR);
        System.out.println("Date: Constructor: the default date is: " + this.toString());
    }

    // constructor for specific date
    public Date(int day, int month, int year) {
        this.setDayMonthYear(day, month, year);
    }

    // constructor for specific date string input wigetDayth pattern "dd-mm-yyyy"
    public Date(String strDate) {
        Date parsedDate = parseDate(strDate);
        this.setDayMonthYear(parsedDate.getDay(), parsedDate.getMonth(), parsedDate.getYear());
    }

    // setters
    public void setDay(int day) {
        if (isValidDay(day))
            this.day = day;
        else
            System.err.println("Date: setDay: invalid day!" + day);
    }

    public void setMonth(int month) {
        if (isValidMonth(month))
            this.month = month;
        else
            System.err.println("Date: setMonth: invalid month!");
    }

    public void setYear(int year) {
        if (isValidYear(year))
            this.year = year;
        else
            System.err.println("Date: setYear: invalid year!");
    }

    public void setDayMonthYear(int day, int month, int year) {
        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
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
    public void addDays(int days) {
        final Date START_DATE = new Date(START_DATE_DAY, START_DATE_MONTH, START_DATE_YEAR);
        int countedDays = diffrenceInDays(this, START_DATE) + days;
        Date result = daysToDate(countedDays, START_DATE);
        setDayMonthYear(result.getDay(), result.getMonth(), result.getYear());
    }

    // add-months method
    // TODO...

    // add-years method
    // TODO...

    // toString method to pattern "dd-mm-yyyy"
    @Override
    public String toString() {
        String output = "";
        String formatedDay = String.format("%02d", this.getDay());
        String formatedMonth = String.format("%02d", this.getMonth());
        String formatedYear = String.format("%04d", this.getYear());
        output = formatedDay + "-" + formatedMonth + "-" + formatedYear;
        return output;
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Date))
            return false;

        Date another = (Date) obj;
        if (this.getDay() != another.getDay() || this.getMonth() != another.getMonth()
                || this.getYear() != another.getYear()) {
            return false;
        }
        return true;
    }

    // compareTo method
    @Override
    public int compareTo(Date another) {
        if (this.getYear() > another.getYear())
            return 1;
        if (this.getYear() < another.getYear())
            return -1;

        if (this.getMonth() > another.getMonth())
            return 1;
        if (this.getMonth() < another.getMonth())
            return -1;

        if (this.getDay() > another.getDay())
            return 1;
        if (this.getDay() < another.getDay())
            return -1;

        return 0;
    }

    // ===============================
    // validation methods://

    // validate day method
    private boolean isValidDay(int day) {
        if (day < 1 || day > maxDaysOfMonth(this.getMonth(), this.getYear()))
            return false;

        return true;
    }

    // validate month method
    private boolean isValidMonth(int month) {
        if (month < 1 || month > 12) {
            return false;
        }
        return true;
    }

    // validate year method
    private boolean isValidYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        }
        return true;
    }

    // ==========================
    // utils methods://

    // return max days of a month
    private int maxDaysOfMonth(int month, int year) {
        ArrayList<Integer> monthsWith31Days = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
        ArrayList<Integer> monthsWith30Days = new ArrayList<Integer>(Arrays.asList(4, 6, 9, 11));

        if (monthsWith31Days.contains(month))
            return 31;

        if (monthsWith30Days.contains(month))
            return 30;

        if (month == 2)
            if (isLeapYear(year))
                return 29;
            else
                return 28;

        // if invalid
        System.err.println("Date: maxDaysOfMonth: invalid month!");
        return -1;
    }

    // return true if year is leap
    private boolean isLeapYear(int year) {
        // check if year is leap
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 4 == 0) && (year % 400 == 0))
            return true;

        return false;
    }

    // parse date with pattern "dd-mm-yyyy"
    private Date parseDate(String ddmmyyyy) {
        String[] splitedStrDate = ddmmyyyy.split("-");

        // check if pattern is not valid
        if (splitedStrDate.length != 3) {
            System.err.println("Date: parseDate: invalid date pattern!");
            return new Date();
        }

        int day = Integer.parseInt(splitedStrDate[0]);
        int month = Integer.parseInt(splitedStrDate[1]);
        int year = Integer.parseInt(splitedStrDate[2]);
        return new Date(day, month, year);
    }

    // return diffrence between two dates in days
    private int diffrenceInDays(Date newerDate, Date olderDate) {
        int result = 0;
        result += countDaysInYears(newerDate.getYear(), olderDate.getYear());
        result += -countDaysInMonths(olderDate) + countDaysInMonths(newerDate);
        result += -olderDate.getDay() + newerDate.getDay();
        return result;
    }

    // return number of days between two years
    private int countDaysInYears(int newerYear, int olderYear) {
        int result = 0;
        int years = newerYear - olderYear;
        result += years * 365;
        result += countLeapYears(newerYear, olderYear);
        return result;
    }

    // return number of leap years between two diffrent dates
    private int countLeapYears(int newerYear, int olderYear) {
        int divBy4 = (newerYear / 4) - (olderYear / 4);
        int divBy100 = (newerYear / 100) - (olderYear / 100);
        int divBy400 = (newerYear / 400) - (olderYear / 400);
        int result = divBy4 - divBy100 + divBy400;
        return result;
    }

    // return number of days between first month (aka jan) and given month
    private int countDaysInMonths(Date date) {
        ArrayList<Integer> months = createMonthsArrayList(date.getMonth());
        months.remove(months.size()-1);
        return sumDaysFromMonths(months, date.getYear());
    }

    // take the month return ArrayList of months up to given month
    private ArrayList<Integer> createMonthsArrayList(int lastMonth) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int month = 1; month <= lastMonth; ++month) {
            result.add(month);
        }
        return result;
    }

    // summation fo days in months
    private int sumDaysFromMonths(ArrayList<Integer> months, int year) {
        int sum = 0;
        for (int month : months) {
            sum += maxDaysOfMonth(month, year);
        }
        return sum;
    }

    // convert number of days to date by adding it to START_DATE
    private Date daysToDate(int days, Date startDate) {
        int[] tempMethodsResult = new int[2];
        int remainingDays = days;

        tempMethodsResult = countYearsInDays(remainingDays, startDate.getYear());
        int years = tempMethodsResult[0];
        remainingDays = tempMethodsResult[1];

        tempMethodsResult = countMonthsInDays(remainingDays, startDate.getMonth(), years);
        int months = tempMethodsResult[0];
        remainingDays = tempMethodsResult[1];
        
        return new Date(remainingDays, months, years);
    }

    // return number of years in days and reminder days
    private int[] countYearsInDays(int days, int startYear) {
        final int DAYS_IN_400_YEARS = 365 * 400 + 97;
        final int DAYS_IN_100_YEARS = 365 * 100 + 24;
        final int DAYS_IN_4_YEARS = 365 * 4 + 1;
        final int DAYS_IN_1_YEAR = 365;

        int years = startYear;
        int remainingDays = days;

        int sign = remainingDays > 0 ? 1 : -1;

        years += sign * (remainingDays / DAYS_IN_400_YEARS) * 400;
        remainingDays = remainingDays % DAYS_IN_400_YEARS;

        years += sign * (remainingDays / DAYS_IN_100_YEARS) * 100;
        remainingDays = remainingDays % DAYS_IN_100_YEARS;

        years += sign * (remainingDays / DAYS_IN_4_YEARS) * 4;
        remainingDays = remainingDays % DAYS_IN_4_YEARS;

        years += sign * (remainingDays / DAYS_IN_1_YEAR);
        remainingDays = remainingDays % DAYS_IN_1_YEAR;

        return new int[] { years, remainingDays };
    }

    // return number of months in days and reminder days
    private int[] countMonthsInDays(int days, int startMonth, int year) {
        int remainingDays = days;
        int months = startMonth;
        int sign = remainingDays > 0 ? 1 : -1;
        while(true) {
            int daysOfMonth = maxDaysOfMonth(months, year);
            if(remainingDays < daysOfMonth) {
                break;
            } else {
                months += sign;
                remainingDays -= sign * daysOfMonth;
            }
        }
        return new int[] { months, remainingDays };
    }

    // return arithmatic mod always positive
    private int mod(int number, int divisor) {
        number = number % divisor;
        number = number + divisor;
        return number % divisor;
    }

}