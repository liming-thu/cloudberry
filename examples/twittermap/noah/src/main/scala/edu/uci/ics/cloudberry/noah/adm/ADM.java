package edu.uci.ics.cloudberry.noah.adm;

import twitter4j.TwitterException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ADM {

    public static final SimpleDateFormat ADMDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat ADMTimeFormat = new SimpleDateFormat("HH:mm:ss.SSS");
    //
    public static final SimpleDateFormat srcDateTimeFmt=new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
    //
    public static String mkADMConstructor(String constructor, String content) {
        StringBuilder sbConstructor = new StringBuilder();
        sbConstructor.append(constructor).append("(\"").append(content).append("\")");
        return sbConstructor.toString();
    }

    public static String mkInt64Constructor(long value) {
        return mkADMConstructor("int64", String.valueOf(value));
    }

    public static String mkInt8Constructor(String value) {
        return mkADMConstructor("int8", value);
    }

    public static String mkInt32Constructor(String value) {
        return mkADMConstructor("int32", value);
    }

    public static String mkFloatConstructor(String value) {
        return mkADMConstructor("float", (Float.toString(Float.parseFloat(value))) + "f");
    }

    public static String mkDateTimeConstructor(Date jdate) {
        return "datetime(\"" + ADMDateFormat.format(jdate) + "T" + ADMTimeFormat.format(jdate) + "\")";
    }

    public static String mkDateTimeStringFromTweet(String srcDateTimeString) throws TwitterException {
        try {
            Date dt = new Date(srcDateTimeFmt.parse(srcDateTimeString).getTime());
            StringBuilder sbDateTime = new StringBuilder();
            sbDateTime.append("datetime(\"").append(ADMDateFormat.format(dt)).append("T").append(ADMTimeFormat.format(dt)).append("\")");
            return sbDateTime.toString();
        }catch (ParseException parseEx){
            throw new TwitterException("unknown datatime");
        }
    }

    public static String mkDateStringFromTweet(String srcDateTimeString) throws TwitterException {
        try {
            Date dt = new Date(srcDateTimeFmt.parse(srcDateTimeString).getTime());
            StringBuilder sbDateTime = new StringBuilder();
            sbDateTime.append("date(\"").append(ADMDateFormat.format(dt)).append("\")");
            return sbDateTime.toString();
        }catch (ParseException parseEx){
            throw new TwitterException("unknown datatime");
        }
    }

    public static void keyValueToSb(StringBuilder sb, String key, String val) throws Exception{
        try {
            sb.append(mkQuoteOnly(key)).append(":").append(val.replaceAll("\\s+", " "));
        }catch (Exception ex){
//            System.out.println("sb:"+sb.toString());
//            System.out.println("key:"+key.toString());
//            System.out.println("val:"+val.toString());
            throw new Exception();
        }
    }

    public static void keyValueToSbWithComma(StringBuilder sb, String key, String val) throws Exception {
        keyValueToSb(sb, key, val);
        sb.append(",");
    }

    public static String mkPoint(String lng, String lat) {
        return "point(\"" + lng + "," + lat + "\")";
    }

    public static String mkQuoteOnly(String str) {
        StringBuilder sbQuote = new StringBuilder();
        sbQuote.append('"').append(str).append('"');
        return sbQuote.toString();
    }
}
