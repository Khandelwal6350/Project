
import java.util.*;

class GymPlan {
    String trainerName;
    String mobile;
    int monthlyFee;
    int yearlyFee;
    String offer;

    public void displayPlan() {
        System.out.println("Trainer Name: " + trainerName);
        System.out.println("Mobile: " + mobile);
        System.out.println("Monthly Plan: ₹" + monthlyFee);
        System.out.println("Yearly Plan: ₹" + yearlyFee + " (" + offer + ")");
    }
}

class Trainer extends GymPlan {
    String[] skills;
    String[] bodyParts;

    public Trainer(String trainerName, String mobile, int monthlyFee, int yearlyFee, String offer,
                   String[] skills, String[] bodyParts) {
        this.trainerName = trainerName;
        this.mobile = mobile;
        this.monthlyFee = monthlyFee;
        this.yearlyFee = yearlyFee;
        this.offer = offer;
        this.skills = skills;
        this.bodyParts = bodyParts;
    }

    public void displayTrainerInfo() {
        displayPlan();
        System.out.println("Body Parts Focused:");
        for (String part : bodyParts)
            System.out.println(" - " + part);
        System.out.println("Skills:");
        for (String skill : skills)
            System.out.println(" - " + skill);
    }
}

class Member {
    String name;
    int age;
    double weight;
    double height;
    Trainer trainer;
    String planType;
    double bmi;

    public void register(Scanner sc, Trainer[] trainers) {
        System.out.print("Enter your name: ");
        name = sc.next();
        System.out.print("Enter your age: ");
        age = sc.nextInt();
        System.out.print("Enter your weight (kg): ");
        weight = sc.nextDouble();
        System.out.print("Enter your height (m): ");
        height = sc.nextDouble();

        calculateBMI();
        System.out.println("Your BMI is: " + bmi);

        System.out.println("\nChoose Trainer:");
        for (int i = 0; i < trainers.length; i++) {
            System.out.println((i + 1) + ". " + trainers[i].trainerName);
        }
        int choice = sc.nextInt();
        if (choice >= 1 && choice <= trainers.length)
            trainer = trainers[choice - 1];

        System.out.print("Choose Plan (Monthly/Yearly): ");
        planType = sc.next();
    }

    private void calculateBMI() {
        bmi = weight / (height * height);
    }

    public void viewProfile() {
        System.out.println("\n--- Member Profile ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Height: " + height + " m");
        System.out.println("BMI: " + bmi);//boady mass index
        System.out.println("Selected Trainer: " + trainer.trainerName);
        System.out.println("Plan Type: " + planType);
        if (planType.equalsIgnoreCase( "monthly")) {
            System.out.println("Amount to Pay: " + trainer.monthlyFee);
        } else {
            System.out.println("Amount to Pay: " + trainer.yearlyFee);
        }
    }
}

public class GYM{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Trainer[] trainers = {
                new Trainer("Raj", "8945471212", 2000, 20000, "2 months free",
                        new String[]{"Strength Training", "Nutrition", "Motivation"},
                        new String[]{"Legs", "Shoulders", "Quads", "Calves"}),

                new Trainer("Ramesh", "9647315856", 2500, 25000, "2.5 months free",
                        new String[]{"Muscle Gain", "Posture Correction"},
                        new String[]{"Biceps", "Chest", "Back", "Triceps"}),

                new Trainer("Rahul", "8476184971", 3000, 30000, "3 months free + Diet Consultation",
                        new String[]{"Functional Training", "Core"},
                        new String[]{"Full Body", "Endurance", "Core", "Posture"}),

                new Trainer("alan", "8476187343", 4000, 40000, "3 months free + Diet Consultation + ",
                        new String[]{"Functional Training", "Core"},
                        new String[]{"Full Body", "Endurance", "Core", "Posture"})
        };

        Member member = new Member();
        int option;

        do {
            System.out.println("\n===== GYM MENU =====");
            System.out.println("1. View Trainers");
            System.out.println("2. Register as Member");
            System.out.println("3. View Member Profile");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    for (Trainer t : trainers) {
                        System.out.println("\n------------------------");
                        t.displayTrainerInfo();
                        System.out.println("------------------------");
                    }
                    break;
                case 2:
                    member.register(sc, trainers);
                    break;
                case 3:
                    member.viewProfile();
                    break;
                case 4:
                    System.out.println("Thank you for using the Gym Management System!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (option != 4);
        sc.close();
    }
}

