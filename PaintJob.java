public class PaintJob {
    //The number of paint cans needed

    public int paintCans;

     // The cost of one coat of paint in dollars

    public float coatCost;

     //Liters of paint needed for one coat

    public float paintNeeded;

     // Name of the project

    private String projectName;

     // The height of the room to paint in feet

    private float Height;

     // The width of the room to paint in feet

    private float Width;

     //The length of the room to paint in feet

    private float Length;

     //The total surface area of the room in ft^2

    private float Area;

     //How much money can be spent on paint

    private float Budget;

     //The price of a single 3.7L can of paint

    private float canPrice;

    private static final float LITER_COVERS_SQUARE_FEET = 100.0f;
    public static final float LITERS_PER_PAINT_CAN = 3.7f;

    public PaintJob() {
        this.projectName = null;
        this.Height = 0;
        this.Width = 0;
        this.Length = 0;
        this.coatCost = 0;
        this.Area = 0;
        this.Budget = 0;
        this.canPrice = 0;
        this.paintCans = 0;
        this.paintNeeded = 0;
    }

    public PaintJob(final String iProjectName, final float iHeight, final float iWidth, final float iLength) {
        if (iProjectName == null || iHeight <= 0 || iWidth <= 0 || iLength <= 0) {
            throw new IllegalArgumentException(
                    "height, width and length must all be greater than zero and project name cannot be null");
        }
        this.projectName = iProjectName;
        this.Height = iHeight;
        this.Width = iWidth;
        this.Length = iLength;
        this.coatCost = 0.0f;
        this.Area = 0;
        this.Budget = 0;
        this.canPrice = 0;

        this.paintNeeded = this.getArea() / LITER_COVERS_SQUARE_FEET;
        this.paintCans = (int) Math.ceil(this.paintNeeded / LITERS_PER_PAINT_CAN);
    }


    public String getProjectName() {
        return projectName;
    }

    public float getArea() {
        Area = 2.0f * ((this.Height * this.Width) + (this.Height * this.Length));
        return Area;
    }


    public float getHeight() {
        return Height;
    }


    public float getWidth() {
        return Width;
    }

    public float getLength() {
        return Length;
    }


    public float getBudget() {
        return Budget;
    }


    public float getCanPrice() {
        return canPrice;
    }


    public void setProjectName(String newProjectName) {
        if (newProjectName == null || newProjectName.length() == 0) {
            throw new IllegalArgumentException("Name cannot be null or have a length of 0");
        }
        this.projectName = newProjectName;
    }


    public void setHeight(float newHeight) {
        if (newHeight <= 0) {
            throw new IllegalArgumentException("Height cannot be less than or equal to zero");
        }
        this.Height = newHeight;
    }


    public void setWidth(float newWidth) {
        if (newWidth <= 0) {
            throw new IllegalArgumentException("Width cannot be less than or equal to zero");
        }
        this.Width = newWidth;
    }


    public void setLength(float newLength) {
        if (newLength <= 0) {
            throw new IllegalArgumentException("Length cannot be less than or equal to zero");
        }
        this.Length = newLength;
    }


    public void setBudget(float newBudget) {
        if (newBudget < 0) {
            throw new IllegalArgumentException("Budget cannot be less than zero");
        }
        this.Budget = newBudget;
    }


    public void setCanPrice(float newCanPrice) {
        if (newCanPrice <= 0) {
            throw new IllegalArgumentException("Can price cannot be less than or equal to zero");
        }
        this.canPrice = newCanPrice;
        this.coatCost = this.paintCans * this.canPrice;
    }

    public float totalCost(int numberOfCoats) {
        if (this.coatCost == 0) {
            throw new IllegalStateException("Can price must be set before this calculation");
        }
        return this.Budget - this.coatCost * numberOfCoats;
    }
}