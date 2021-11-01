import managers.*;
import objects.*;
import utilities.Methods;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        //javac *java
        //java Main input.txt output.txt

        String inputTxt = "input.txt";
        String outputTxt = "output.txt";
        //String inputTxt = args[0];
        //String outputTxt = args[1];
        Methods.writeFileasString(inputTxt,"\r"); //thanks to that part we can read the last part.

        Date date = new Date();

        ArrayList<UserObject> userObjects = new ArrayList<>();
        ArrayList<AnniversaryObject> anniversaryObjects = new ArrayList<>();
        ArrayList<BirthdayObject> birthdayObjects = new ArrayList<>();
        ArrayList<AppoinmentObject> appoinmentObjects = new ArrayList<>();
        ArrayList<MeetingObject> meetingObjects = new ArrayList<>();
        ArrayList<ConcertObject> concertObjects = new ArrayList<>();
        ArrayList<SportObject> sportObjects = new ArrayList<>();
        ArrayList<TheaterObject> theaterObjects = new ArrayList<>();
        ArrayList<CourseObject> courseObjects = new ArrayList<>();

        UserManager userManager = new UserManager();
        AnniversaryManager anniversaryManager = new AnniversaryManager();
        BirthdayManager birthdayManager = new BirthdayManager();
        AppoinmentManager appoinmentManager = new AppoinmentManager();
        MeetingManager meetingManager = new MeetingManager();
        ConcertManager concertManager = new ConcertManager();
        TheaterManager theaterManager = new TheaterManager();
        SportManager sportManager = new SportManager();
        CourseManager courseManager = new CourseManager();
        EventManager eventManager = new EventManager();

        ArrayList<Integer> integerEventIdArrayList = new ArrayList<>();
        integerEventIdArrayList.add(-1);

        for (int i = 0; i< Methods.CreateList(inputTxt).length; i++)
        {
            String[] templine = Methods.CreateList(inputTxt)[i].split(" ");

            //SAVE USER
            if (templine[0].equals("SAVE") && templine[1].equals("USER"))
            {
                int userID = Integer.parseInt(templine[2]);
                String name = "";
                for (int j=3;j< templine.length;j++){
                    name += " " + templine[j];
                }
                name = name.substring(1,name.length()-1);
                ArrayList<UserObject> geciciIDAmbari = new ArrayList<UserObject>();
                geciciIDAmbari.addAll(userObjects);

                Methods.writeFileasString(outputTxt,"COMMAND: " + templine[0] + " " + templine[1] + " " + templine[2] + " " + name);
                try{
                    userObjects.add(userManager.find(geciciIDAmbari,userID,name,outputTxt));
                    Methods.writeFileasString(outputTxt,name + " SAVED");
                }catch (Exception e){

                }
            }

            //SAVE ANNIVERSARY
            else if (templine[0].equals("SAVE") && templine[1].equals("ANNIVERSARY"))
            {
                String tamTarih = templine[2];
                SimpleDateFormat formatter = new SimpleDateFormat(tamTarih);
                int userID = Integer.parseInt(templine[3]);
                int anniversaryID = Integer.parseInt(templine[4]);
                String description = "";
                for (int j=5;j< templine.length;j++){
                    description += " " + templine[j];
                }
                description = description.substring(1,description.length()-1);

                Methods.writeFileasString(outputTxt,"COMMAND: " + templine[0] + " " + templine[1] + " " + templine[2] + " " + templine[3] + " " + templine[4] + " " + description);

                try{
                    userManager.checkVariability(userObjects,userID,outputTxt);
                    eventManager.checkVariability(integerEventIdArrayList,anniversaryID,"ANNIVERSARY",outputTxt);
                    anniversaryObjects.add(anniversaryManager.find(anniversaryObjects,anniversaryID,outputTxt,userID,description,formatter,date));


                    String tempName = null;
                    for (UserObject var: userObjects){
                        if (var.getUserID()==userID){
                            tempName = var.getFullName();
                        }
                    }
                    Methods.writeFileasString(outputTxt,description + " ADDED TO " + tempName + "'S AGENDA");
                    integerEventIdArrayList.add(anniversaryID);
                }catch (Exception e){

                }
            }

            //SAVE BIRTHDAY
            else if (templine[0].equals("SAVE") && templine[1].equals("BIRTHDAY"))
            {
                String tamTarih = templine[2];
                SimpleDateFormat formatter = new SimpleDateFormat(tamTarih);
                int userID = Integer.parseInt(templine[3]);
                int birthdayID = Integer.parseInt(templine[4]);
                String description = "";
                for (int j=5;j< templine.length;j++){
                    description += " " + templine[j];
                }
                description = description.substring(1,description.length()-1);

                Methods.writeFileasString(outputTxt,"COMMAND: " + templine[0] + " " + templine[1] + " " + templine[2] + " " + templine[3] + " " + templine[4] + " " + description);

                try{
                    userManager.checkVariability(userObjects,userID,outputTxt);
                    eventManager.checkVariability(integerEventIdArrayList,birthdayID,"BIRTHDAY",outputTxt);
                    birthdayObjects.add(birthdayManager.find(birthdayObjects,userID,date,formatter,birthdayID,description,outputTxt));

                    String tempName = null;
                    for (UserObject var: userObjects){
                        if (var.getUserID()==userID){
                            tempName = var.getFullName();
                        }
                    }
                    Methods.writeFileasString(outputTxt,description + " ADDED TO " + tempName + "'S AGENDA");
                    integerEventIdArrayList.add(birthdayID);
                }catch (Exception e){
                }
            }

            //ARRANGE APPOINTMENT
            else if (templine[0].equals("ARRANGE") && templine[1].equals("APPOINTMENT"))
            {
                String tamTarih = templine[2] + " " + templine[3];
                SimpleDateFormat formatter = new SimpleDateFormat(tamTarih);
                int duration = Integer.parseInt(templine[4]);
                String[] userIDs = Methods.CreateListComma(templine[5]);
                int appoinmentID = Integer.parseInt(templine[6].substring(0,templine[6].length()-1));

                Methods.writeFileasString(outputTxt,"COMMAND: " + templine[0] + " " + templine[1] + " " + templine[2] + " " + templine[3] + " " + templine[4] + " " + templine[5] + " " + templine[6]);
                try{
                    for (String user : userIDs)
                    {
                        int userID = Integer.parseInt(user);
                        if (userManager.checkVariability(userObjects,userID,outputTxt)!=null){
                            break;
                        }
                    }
                    appoinmentObjects.add(appoinmentManager.find(appoinmentObjects,date,formatter,duration,userIDs,appoinmentID,outputTxt));
                    eventManager.checkVariability(integerEventIdArrayList,appoinmentID,"APPOINTMENT",outputTxt);
                    integerEventIdArrayList.add(appoinmentID);

                    Methods.writeFileasString(outputTxt,"AN APPOINTMENT ARRANGED FOR " + templine[5] + " AT " + tamTarih);
                }catch (Exception e){
                }
            }

            //ARRANGE MEETING
            else if (templine[0].equals("ARRANGE") && templine[1].equals("MEETING"))
            {
                String tamTarih = templine[2] + " " + templine[3];
                SimpleDateFormat formatter = new SimpleDateFormat(tamTarih);
                int duration = Integer.parseInt(templine[4]);
                String[] userIDs = Methods.CreateListComma(templine[5]);
                int meetingID = Integer.parseInt(templine[6].substring(0,templine[6].length()-1));

                Methods.writeFileasString(outputTxt,"COMMAND: " + templine[0] + " " + templine[1] + " " + templine[2] + " " + templine[3] + " " + templine[4] + " " + templine[5] + " " + templine[6]);

                try{
                    for (String user : userIDs)
                    {
                        int userID = Integer.parseInt(user);
                        if (userManager.checkVariability(userObjects,userID,outputTxt)!=null){
                            break;
                        }
                    }
                    meetingObjects.add(meetingManager.find(meetingObjects,date,formatter,duration,userIDs,meetingID,outputTxt));
                    eventManager.checkVariability(integerEventIdArrayList,meetingID,"MEETING",outputTxt);
                    integerEventIdArrayList.add(meetingID);

                    Methods.writeFileasString(outputTxt,"A MEETING ARRANGED FOR " + templine[5] + " AT " + tamTarih);
                }catch (Exception e){
                }
            }


            //ARRANGE CONCERT
            else if (templine[0].equals("ARRANGE") && templine[1].equals("CONCERT"))
            {
                int quota = Integer.parseInt(templine[2]);
                String tamTarih = templine[3] + " " + templine[4];
                SimpleDateFormat formatter = new SimpleDateFormat(tamTarih);
                int eventID = Integer.parseInt(templine[5]);
                String eventName = "";
                for (int j=6;j< templine.length;j++){
                    eventName += " " + templine[j];
                }
                eventName = eventName.substring(1,eventName.length()-1);

                Methods.writeFileasString(outputTxt,"COMMAND: " + templine[0] + " " + templine[1] + " " + templine[2] + " " + templine[3] + " " + templine[4] + " " + templine[5] + " " + eventName);
                try{
                    concertObjects.add(concertManager.find(concertObjects,date,quota,formatter,eventID,eventName,outputTxt));
                    eventManager.checkVariability(integerEventIdArrayList,eventID,"EVENT",outputTxt);
                    integerEventIdArrayList.add(eventID);

                    Methods.writeFileasString(outputTxt,eventName + " ARRANGED AT " + tamTarih);
                }catch (Exception e){
                }
            }


            //ARRANGE THEATER
            else if (templine[0].equals("ARRANGE") && templine[1].equals("THEATER"))
            {
                int quota = Integer.parseInt(templine[2]);
                String tamTarih = templine[3] + " " + templine[4];
                SimpleDateFormat formatter = new SimpleDateFormat(tamTarih);
                int eventID = Integer.parseInt(templine[5]);
                String eventName = "";
                for (int j=6;j< templine.length;j++){
                    eventName += " " + templine[j];
                }
                eventName = eventName.substring(1,eventName.length()-1);

                Methods.writeFileasString(outputTxt,"COMMAND: " + templine[0] + " " + templine[1] + " " + templine[2] + " " + templine[3] + " " + templine[4] + " " + templine[5] + " " + eventName);
                try{
                    theaterObjects.add(theaterManager.find(theaterObjects,date,quota,formatter,eventID,eventName,outputTxt));
                    eventManager.checkVariability(integerEventIdArrayList,eventID,"EVENT",outputTxt);
                    integerEventIdArrayList.add(eventID);

                    Methods.writeFileasString(outputTxt,eventName + " ARRANGED AT " + tamTarih);
                }catch (Exception e){
                }
            }


            //ARRANGE SPORT
            else if (templine[0].equals("ARRANGE") && templine[1].equals("SPORT"))
            {
                int quota = Integer.parseInt(templine[2]);
                String tamTarih = templine[3] + " " + templine[4];
                SimpleDateFormat formatter = new SimpleDateFormat(tamTarih);
                int eventID = Integer.parseInt(templine[5]);
                String eventName = "";
                for (int j=6;j< templine.length;j++){
                    eventName += " " + templine[j];
                }
                eventName = eventName.substring(1,eventName.length()-1);

                Methods.writeFileasString(outputTxt,"COMMAND: " + templine[0] + " " + templine[1] + " " + templine[2] + " " + templine[3] + " " + templine[4] + " " + templine[5] + " " + eventName);
                try{
                    sportObjects.add(sportManager.find(sportObjects,date,quota,formatter,eventID,eventName,outputTxt));
                    eventManager.checkVariability(integerEventIdArrayList,eventID,"EVENT",outputTxt);
                    integerEventIdArrayList.add(eventID);

                    Methods.writeFileasString(outputTxt,eventName + " ARRANGED AT " + tamTarih);
                }catch (Exception e){
                }
            }


            //ARRANGE COURSE
            else if (templine[0].equals("ARRANGE") && templine[1].equals("COURSE"))
            {
                int quota = Integer.parseInt(templine[2]);
                String tamTarih = templine[3] + " " + templine[4];
                SimpleDateFormat formatter = new SimpleDateFormat(tamTarih);

                String str = templine[3];
                String[] arrOfStr = str.split("/", 3);
                int day = Integer.valueOf(arrOfStr[0]);
                int month = Integer.valueOf(arrOfStr[1]);
                int year = Integer.valueOf(arrOfStr[2]);

                LocalDate localDate = LocalDate.of(year, month, day);
                java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();

                int courseID = Integer.parseInt(templine[5]);
                String courseName = "";
                for (int j=6;j< templine.length;j++){
                    courseName += " " + templine[j];
                }
                courseName = courseName.substring(1,courseName.length()-1);
                Methods.writeFileasString(outputTxt,"COMMAND: " + templine[0] + " " + templine[1] + " " + templine[2] + " " + templine[3] + " " + templine[4] + " " + templine[5] + " " + courseName);
                try{
                    courseObjects.add(courseManager.find(courseObjects,date,quota,formatter,courseID,courseName,outputTxt));
                    eventManager.checkVariability(integerEventIdArrayList,courseID,"COURSE",outputTxt);
                    integerEventIdArrayList.add(courseID);

                    Methods.writeFileasString(outputTxt,courseName + " ARRANGED ON " + dayOfWeek.toString() + " " + templine[4]);

                }catch (Exception e){
                }
            }



            //ATTEND EVENT
            else if (templine[0].equals("ATTEND") && templine[1].equals("EVENT"))
            {
                Methods.writeFileasString(outputTxt,"COMMAND: " + templine[0] + " " + templine[1] + " " + templine[2] + " " + templine[3]);

            }

            //ATTEND COURSE
            else if (templine[0].equals("ATTEND") && templine[1].equals("COURSE"))
            {
                Methods.writeFileasString(outputTxt,"COMMAND: " + templine[0] + " " + templine[1] + " " + templine[2] + " " + templine[3]);
            }

        }


        //System.out.println("-----------------------------------");
        //userobjects arrayı kontrol
        /*
        for (int a=0;a< userObjects.size();a++){
            System.out.println(userObjects.get(a).getUserID() + " " + userObjects.get(a).getFullName());
        }

         */



        //anniversaryobjects arrayını kontrol
        /*
        for (int i = 0; i < anniversaryObjects.size(); i++) {
            System.out.println(anniversaryObjects.get(i).dateWithoutHour() + " " + anniversaryObjects.get(i).getUserID() + " " + anniversaryObjects.get(i).getAnniversaryID() + " " + anniversaryObjects.get(i).getDescription());
        }
         */


        //birthdayObjects arrayını kontrol
        /*
        for (int i=0;i< birthdayObjects.size();i++){
            System.out.println(birthdayObjects.get(i).dateWithoutHour() + " " + birthdayObjects.get(i).getUserID() + " " + birthdayObjects.get(i).getBirthDayID() + " " + birthdayObjects.get(i).getDescription());
        }
         */

        //appoinmentObjects kontrol
        /*
        for (int i=0;i<appoinmentObjects.size();i++){
            System.out.println(appoinmentObjects.get(i).getDateWithHour() + " " + appoinmentObjects.get(i).getDuration() + " " + appoinmentObjects.get(i).getUserIDs() + " " + appoinmentObjects.get(i).getAppoinmentID());
        }
         */


        //meetingObjects arrayını kontrol
        /*
        for (int i=0;i< meetingObjects.size();i++){
            System.out.println(meetingObjects.get(i).getDateWithHour()+ " " + meetingObjects.get(i).getDuration() + " " + meetingObjects.get(i).getUserIDs() + " " + meetingObjects.get(i).getMeetingID());
        }
         */

        //concertObjects kontrol
        /*
        for (int i=0;i< concertObjects.size();i++){
            System.out.println(concertObjects.get(i).getQuota() + " " + concertObjects.get(i).getDateWithHour() + " " + concertObjects.get(i).getEventID() + " " + concertObjects.get(i).getEventName());
        }
         */

        //theaterObjects kontrol
        /*
        for (int a =0;a< theaterObjects.size();a++){
            System.out.println(theaterObjects.get(a).getQuota() + " " + theaterObjects.get(a).getDateWithHour() + " " + theaterObjects.get(a).getEventID() + " " + theaterObjects.get(a).getEventName());
        }
         */

        //sportObjects kontrol
        /*
        for (int a=0;a< sportObjects.size();a++){
            System.out.println(sportObjects.get(a).getDuration() + " " + sportObjects.get(a).getDateWithHour() + " " + sportObjects.get(a).getEventID() + " " + sportObjects.get(a).getEventName());
        }
         */

        //courseObjects control
        /*
        for (int a=0;a< courseObjects.size();a++){
            System.out.println(courseObjects.get(a).getQuota() + " " + courseObjects.get(a).getDateWithHour() + " " + courseObjects.get(a).getCourseID() + " " + courseObjects.get(a).getCourseName());
        }
         */

    }
}
