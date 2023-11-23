import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static Float parseFloat(final String s) {
        try {
            return Float.parseFloat(s);
        } catch (Exception ignored) {
            return null;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Enter the project name: ");
            String name = in.readLine();
            if (name.length() == 0) {
                System.err.println("Invalid name given, exiting...");
                return;
            }

            System.out.print("Enter your budget: ");
            Float budget = parseFloat(in.readLine());
            if (budget == null || budget <= 0) {
                System.err.println("Invalid budget given, exiting...");
                return;
            }

            System.out.print("Enter the wall height (feet): ");
            Float height = parseFloat(in.readLine());
            if (height == null || height <= 0) {
                System.err.println("Invalid height given, exiting...");
                return;
            }

            System.out.print("Enter the wall width (feet): ");
            Float width = parseFloat(in.readLine());
            if (width == null || width <= 0) {
                System.err.println("Invalid width given, exiting...");
                return;
            }

            System.out.print("Enter the wall length (feet): ");
            Float length = parseFloat(in.readLine());
            if (length == null || length <= 0) {
                System.err.println("Invalid length given, exiting...");
                return;
            }

            System.out.print("Enter the cost of a can of paint: $");
            Float canCost = parseFloat(in.readLine());
            if (canCost == null || canCost <= 0) {
                System.err.println("Invalid price given, exiting...");
                return;
            }

            System.out.print("\n-----------------------\n\n");

            PaintJob pj = new PaintJob(name, height, width, length);
            pj.setBudget(budget);
            pj.setCanPrice(canCost);

            System.out.printf("Project Name: %s\n", pj.getProjectName());

            System.out.printf("Wall area: %.2f ft^2\n", pj.getArea());

            System.out.print("\n-------------------------\n\n");

            for (int i = 1; i <= 3; i++) {
                final float coatPaint = pj.paintNeeded * i;
                final int coatCans = (int) Math.ceil(coatPaint / PaintJob.LITERS_PER_PAINT_CAN);
                final float coatCost = pj.getCanPrice() * coatCans;

                System.out.printf("Amount of paint needed: %.2f L\n", coatPaint);
                System.out.printf("Number of paint cans needed: %d\n", coatCans);
                System.out.printf("The price of %d coat%s of paint: $%.2f\n");
                System.out.printf("The amount of money left from the budget after a %d coat%s: $%.2f\n");
                System.out.print("\n------------------------------\n\n");
            }
        } catch (final Exception e) {
            System.err.printf("Error during execution of main function: %s\n", e);
        }
    }

}
