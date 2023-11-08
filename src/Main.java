import java.io.*;
import java.util.*;
import java.text.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "activity_data_10.csv";

        Scanner keyboard = new Scanner(System.in);

        ArrayList<activity> activities = new ArrayList<>();


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try (Scanner sc = new Scanner(new File(fileName))) {
            if (sc.hasNextLine())
                sc.nextLine();   // read the header line containing column titles, but don't use it

            // read one line at a time into a String, and parse the String into tokens (parts)

            while (sc.hasNextLine()) {
                String line = sc.nextLine();             // read full line ( delimited by a "\n" )
                String[] tokens = line.split(",");  // split line using a comma as the delimiter (separator)

                String activityType = tokens[0];  // extract first token/field from the tokens array (i.e. the name)
                Date date = null;
                try {
                    date = dateFormat.parse(tokens[1]);
                } catch (ParseException e) {
                    System.out.println("Date is NOT ACCEPTABLE");
                }


                double duration = Double.parseDouble(tokens[2]);  // e.g. Convert String "1.82" to double 1.82
                double distance = Double.parseDouble(tokens[3]);
                int heartrate = Integer.parseInt(tokens[4]);

                if (activityType.equals("Running")) {
                    activities.add(new Runnin(activityType, duration, date, distance, heartrate));
                } else if (activityType.equals("Swimming")) {
                    activities.add(new Swimmin(activityType, duration, date, distance, heartrate));
                } else if (activityType.equals("Cycling")) {
                    activities.add(new Cycling(activityType, duration, date, distance, heartrate));
                }
            }

        } catch (FileNotFoundException exception) {
            System.out.println("FileNotFoundException caught. The file " + fileName + " may not exist." + exception);
        }


        System.out.println("========================");

        Collections.reverse(activities);//used for reverse version lists

        printActivty(activities);

        System.out.println("========================");

        while (true) {
            System.out.println("SELECT WHAT YOU WISH TO VIEW");
            System.out.println("1: Calories Burned \n2: Date of Activity\n3:Duration of Activity\n4: Type of Activity\n5: Distance (Km)\n 6: Average Distance Per Activity \n 7:Calories Burned\n 6: End Programme");
            int menuInput = keyboard.nextInt();
            int menuSelector;
            switch (menuInput) {


                case 1:

                    Collections.sort(activities, (a1, a2) -> {
                                return (int) (a1.getCaloriesBurned() - a2.getCaloriesBurned());
                            }
                    );

                    System.out.println("DO YOU WANT ASCENDING OR DESCENDING?");
                    System.out.println("1: ASCENDING\n2: DESCENDING");
                    menuSelector = keyboard.nextInt();

                    if (menuSelector == 2) {
                        Collections.reverse(activities);//used for reverse version lists
                    }

                    System.out.println("Do you want to see only a certain activity??");
                    System.out.println("1: Yes\n2:No");
                    menuSelector = keyboard.nextInt();
                    if (menuSelector == 1) {
                        System.out.println("1: Swimming\n2: Running\n3:Cycling");

                        if (menuSelector == 1) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Swimming")) ;
                            }
                        }

                        if (menuSelector == 2) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Running")) ;
                            }
                        }

                        if (menuSelector == 3) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Cycling")) ;
                            }
                        }

                    }

                    System.out.println("Do you want a minimum distance?");
                    System.out.println("1: Yes\n2:No");
                    menuSelector = keyboard.nextInt();
                    if (menuSelector == 1) {

                        if (menuSelector == 1) {
                            System.out.println("INPUT A MINIMUM DISTANCE");
                            menuSelector = keyboard.nextInt();
                            for (activity Activity : activities) {
                                if (Activity.getDistance() >= (menuSelector)) ;
                            }
                        }

                        System.out.println("Do you want a minimum duration?");
                        System.out.println("1: Yes\n2: No");
                        menuSelector = keyboard.nextInt();
                        if (menuSelector == 1) {
                            System.out.println("INPUT A MINIMUM DURATION");
                            menuSelector = keyboard.nextInt();
                            for (activity Activity : activities) {
                                if (Activity.getDuration() >= (menuSelector)) ;
                            }
                        }

                    }


                    printActivty(activities);
                    break;

                case 2:

                    Collections.sort(activities);//already sorts by date

                    System.out.println("DO YOU WANT ASCENDING OR DESCENDING?");
                    System.out.println("1: ASCENDING\n2: DESCENDING");
                    menuSelector = keyboard.nextInt();

                    if (menuSelector == 2) {
                        Collections.reverse(activities);//used for reverse version lists
                    }

                    System.out.println("Do you want to see only a certain activity?");
                    System.out.println("1: Yes\n2:No");
                    menuSelector = keyboard.nextInt();
                    if (menuSelector == 1) {
                        System.out.println("1: Swimming\n2: Running\n3:Cycling");

                        if (menuSelector == 1) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Swimming")) ;
                            }
                        }

                        if (menuSelector == 2) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Running")) ;
                            }
                        }

                        if (menuSelector == 3) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Cycling")) ;
                            }
                        }

                    }

                    System.out.println("Do you want a minimum distance?");
                    System.out.println("1: Yes\n2:No");
                    menuSelector = keyboard.nextInt();
                    if (menuSelector == 1) {

                        if (menuSelector == 1) {
                            System.out.println("INPUT A MINIMUM DISTANCE");
                            menuSelector = keyboard.nextInt();
                            for (activity Activity : activities) {
                                if (Activity.getDistance() >= (menuSelector)) ;
                            }
                        }

                        System.out.println("Do you want a minimum duration?");
                        System.out.println("1: Yes\n2: No");
                        menuSelector = keyboard.nextInt();
                        if (menuSelector == 1) {
                            System.out.println("INPUT A MINIMUM DURATION");
                            menuSelector = keyboard.nextInt();
                            for (activity Activity : activities) {
                                if (Activity.getDuration() >= (menuSelector)) ;
                            }
                        }

                    }


                    printActivty(activities);
                    break;


                case 3:

                    Collections.sort(activities, (a1, a2) -> {
                                return (int) (a1.getDuration() - a2.getDuration());
                            }
                    );
                    System.out.println("DO YOU WANT ASCENDING OR DESCENDING?");
                    System.out.println("1: ASCENDING\n2: DESCENDING");
                    menuSelector = keyboard.nextInt();

                    if (menuSelector == 2) {
                        Collections.reverse(activities);//used for reverse version lists
                    }

                    System.out.println("Do you want to see only a certain activity?");
                    System.out.println("1: Yes\n2:No");
                    menuSelector = keyboard.nextInt();
                    if (menuSelector == 1) {
                        System.out.println("1: Swimming\n2: Running\n3:Cycling");

                        if (menuSelector == 1) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Swimming")) ;
                            }
                        }

                        if (menuSelector == 2) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Running")) ;
                            }
                        }

                        if (menuSelector == 3) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Cycling")) ;
                            }
                        }

                    }

                    System.out.println("Do you want a minimum distance?");
                    System.out.println("1: Yes\n2:No");
                    menuSelector = keyboard.nextInt();
                    if (menuSelector == 1) {

                        if (menuSelector == 1) {
                            System.out.println("INPUT A MINIMUM DISTANCE");
                            menuSelector = keyboard.nextInt();
                            for (activity Activity : activities) {
                                if (Activity.getDistance() >= (menuSelector)) ;
                            }
                        }

                        System.out.println("Do you want a minimum duration?");
                        System.out.println("1: Yes\n2: No");
                        menuSelector = keyboard.nextInt();
                        if (menuSelector == 1) {
                            System.out.println("INPUT A MINIMUM DURATION");
                            menuSelector = keyboard.nextInt();
                            for (activity Activity : activities) {
                                if (Activity.getDuration() >= (menuSelector)) ;
                            }
                        }

                    }


                    printActivty(activities);
                    break;


                case 4:

                    Collections.sort(activities, (a1, a2) -> {
                                return a1.getType().compareTo(a2.getType());
                            }
                    );
                    System.out.println("DO YOU WANT ASCENDING OR DESCENDING?");
                    System.out.println("1: ASCENDING\n2: DESCENDING");
                    menuSelector = keyboard.nextInt();

                    if (menuSelector == 2) {
                        Collections.reverse(activities);//used for reverse version lists
                    }

                    System.out.println("Do you want to see only a certain activity?");
                    System.out.println("1: Yes\n2:No");
                    menuSelector = keyboard.nextInt();
                    if (menuSelector == 1) {
                        System.out.println("1: Swimming\n2: Running\n3:Cycling");

                        if (menuSelector == 1) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Swimming")) ;
                            }
                        }

                        if (menuSelector == 2) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Running")) ;
                            }
                        }

                        if (menuSelector == 3) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Cycling")) ;
                            }
                        }

                    }

                    System.out.println("Do you want a minimum distance?");
                    System.out.println("1: Yes\n2:No");
                    menuSelector = keyboard.nextInt();
                    if (menuSelector == 1) {

                        if (menuSelector == 1) {
                            System.out.println("INPUT A MINIMUM DISTANCE");
                            menuSelector = keyboard.nextInt();
                            for (activity Activity : activities) {
                                if (Activity.getDistance() >= (menuSelector)) ;
                            }
                        }

                        System.out.println("Do you want a minimum duration?");
                        System.out.println("1: Yes\n2: No");
                        menuSelector = keyboard.nextInt();
                        if (menuSelector == 1) {
                            System.out.println("INPUT A MINIMUM DURATION");
                            menuSelector = keyboard.nextInt();
                            for (activity Activity : activities) {
                                if (Activity.getDuration() >= (menuSelector)) ;
                            }
                        }

                    }


                    printActivty(activities);
                    break;

                case 5:

                    Collections.sort(activities, (a1, a2) -> {
                                return (int) (a1.getDistance() - a2.getDistance());
                            }
                    );
                    System.out.println("DO YOU WANT ASCENDING OR DESCENDING?");
                    System.out.println("1: ASCENDING\n2: DESCENDING");
                    menuSelector = keyboard.nextInt();

                    if (menuSelector == 2) {
                        Collections.reverse(activities);//used for reverse version lists
                    }

                    System.out.println("Do you want to see only a certain activity?");
                    System.out.println("1: Yes\n2:No");
                    menuSelector = keyboard.nextInt();
                    if (menuSelector == 1) {
                        System.out.println("1: Swimming\n2: Running\n3:Cycling");

                        if (menuSelector == 1) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Swimming")) ;
                            }
                        }

                        if (menuSelector == 2) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Running")) ;
                            }
                        }

                        if (menuSelector == 3) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Cycling")) ;
                            }
                        }

                    }

                    System.out.println("Do you want a minimum distance?");
                    System.out.println("1: Yes\n2:No");
                    menuSelector = keyboard.nextInt();
                    if (menuSelector == 1) {

                        if (menuSelector == 1) {
                            System.out.println("INPUT A MINIMUM DISTANCE");
                            menuSelector = keyboard.nextInt();
                            for (activity Activity : activities) {
                                if (Activity.getDistance() >= (menuSelector)) ;
                            }
                        }

                        System.out.println("Do you want a minimum duration?");
                        System.out.println("1: Yes\n2: No");
                        menuSelector = keyboard.nextInt();
                        if (menuSelector == 1) {
                            System.out.println("INPUT A MINIMUM DURATION");
                            menuSelector = keyboard.nextInt();
                            for (activity Activity : activities) {
                                if (Activity.getDuration() >= (menuSelector)) ;
                            }
                        }

                    }


                    printActivty(activities);
                    break;


                case 7:
                    System.out.println("Select Which Activity you want to get the average for?");
                    System.out.println("1: Swimming\n2: Running\n3:Cycling");
                    menuSelector = keyboard.nextInt();
                    if (menuSelector == 1) {


                        if (menuSelector == 1) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Swimming")) ;
                            }
                        }

                        if (menuSelector == 2) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Running")) ;
                            }
                        }

                        if (menuSelector == 3) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Cycling")) ;
                            }
                        }
                        double total = 0;
                        for (activity Activity : activities) {
                            total += Activity.getDuration();
                        }
                        double avergae = total / activities.size();

                        System.out.println(avergae);
                    }
                    break;
                case 8:
                    System.out.println("Select Which Activity you want to get the average for?");
                    System.out.println("1: Swimming\n2: Running\n3:Cycling");
                    menuSelector = keyboard.nextInt();
                    if (menuSelector == 1) {


                        if (menuSelector == 1) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Swimming")) ;
                            }
                        }

                        if (menuSelector == 2) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Running")) ;
                            }
                        }

                        if (menuSelector == 3) {
                            for (activity Activity : activities) {
                                if (Activity.getType().equals("Cycling")) ;
                            }
                        }
                        double total = 0;
                        for (activity Activity : activities) {
                            total += Activity.getCaloriesBurned();
                        }
                        double avergae = total / activities.size();

                        System.out.println(avergae);
                    }
                    break;

                case 9:
                    System.exit(0);
            }
        }

    }

    public static void printActivty(ArrayList<activity> activities) {
        for (activity Activity : activities) {
            System.out.println(Activity);
        }
    }
}

