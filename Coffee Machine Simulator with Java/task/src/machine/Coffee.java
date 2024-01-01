package machine;

public class Coffee {
    private int cups = 9;
    private int water;
    private int milk;
    private int beans;
    private int amountWater = 400;
    private int amountMilk = 540;
    private int amountBeans = 120;
    private int cash = 550;
    private String notEnough;

    public Coffee() {
    }

    public String getIngredients() {
        int liquid = this.water * this.cups;
        int creamer = this.milk * this.cups;
        int grams = this.beans * this.cups;

        StringBuilder ingredients = new StringBuilder();
        ingredients.append(liquid).append(" ml of water\n")
                .append(creamer).append(" ml of milk\n")
                .append(grams).append(" g of coffee beans\n");

        return ingredients.toString();
    }
    // getter methods
    public int getCups() {
        return this.cups;
    }
    public int getWater() {return this.water;}
    public int getMilk() {return this.milk;}
    public int getBeans() {return this.beans;}
    public int getAmountWater() {return this.amountWater;}
    public int getAmountMilk() {return this.amountMilk;}
    public int getAmountBeans() {return this.amountBeans;}
    public int getCash() {return this.cash;}
    public String getNotEnough() {return this.notEnough;}

    // setter methods
    public void setCups(int glass) {
        this.cups += glass;
    }
    public void setAmountWater(int addWater) {
        this.amountWater += addWater;
    }
    public void setAmountMilk(int addMilk) {
        this.amountMilk += addMilk;
    }

    public void setAmountBeans(int addBeans) {
        this.amountBeans += addBeans;
    }
    public void setCash(int money) {
        this.cash += money;
    }

    public void makeCoffee(String coffee) {
        switch (coffee) {
            case "Espresso" :
                this.amountWater -= 250;
                this.amountBeans -= 16;
                this.cash += 4;
                this.cups -= 1;
                break;
            case "Latte" :
                this.amountWater -= 350;
                this.amountMilk -= 75;
                this.amountBeans -= 20;
                this.cash += 7;
                this.cups -= 1;
                break;
            case "Cappuccino" :
                this.amountWater -= 200;
                this.amountMilk -= 100;
                this.amountBeans -= 12;
                this.cash += 6;
                this.cups -= 1;
                break;
        }
    }

    public void takeMoney() {
        this.cash -= this.cash;
    }
    // checking if coffee can be made
    public boolean canMakeIt(String coffee) {
        boolean yesOrNo = false;

        int neededWater;
        int neededMilk;
        int neededBeans;

        if (coffee.equals("Espresso")) {
            neededWater = 250;
            neededBeans = 16;
            if (this.amountWater - neededWater >= 0 && this.amountBeans - neededBeans >= 0) {
                yesOrNo = true;
            } else if (this.amountMilk - neededWater < 0) {
                notEnough = "water";
            } else if (this.amountBeans - neededBeans < 0) {
                notEnough = "coffee beans";
            } else {
                notEnough = "water and coffee beans";
            }
        }
        else if (coffee.equals("Latte")) {
            neededWater = 350;
            neededMilk = 75;
            neededBeans = 20;
            if (this.amountWater - neededWater >= 0 && this.amountMilk - neededMilk >= 0 &&
            this.amountBeans - neededBeans >= 0) {
                yesOrNo = true;
            } else if (this.amountWater - neededWater < 0) {
                notEnough = "water";
            } else if (this.amountMilk - neededMilk < 0) {
                notEnough = "milk";
            } else if (this.amountBeans - neededBeans < 0) {
                notEnough = "coffee beans";
            } else {
                notEnough = "water, milk, and coffee beans";
            }
        }
        else if(coffee.equals("Cappuccino")) {
            neededWater = 200;
            neededMilk = 100;
            neededBeans = 12;
            if (this.amountWater - neededWater >= 0 && this.amountMilk - neededMilk >= 0
            && this.amountBeans - neededBeans >= 0) {
                yesOrNo = true;
            } else if (this.amountWater - neededWater < 0) {
                notEnough = "water";
            } else if (this.amountMilk - neededMilk < 0) {
                notEnough = "milk";
            } else if (this.amountBeans - neededBeans < 0) {
                notEnough = "coffee beans";
            } else {
                notEnough = "water, milk, and coffee beans";
            }
        }
        return yesOrNo;
    }

    public int howManyCups() {
        int drink = 0;
        int checkW = 0;
        int checkM = 0;
        int checkB = 0;

        for (int i = this.water; i <= this.amountWater; i += this.water) {
            checkW += 1;
        }

        for (int i = this.milk; i <= this.amountMilk; i += this.milk) {
            checkM += 1;
        }

        for (int i = this.beans; i <= this.amountBeans; i += this.beans) {
            checkB += 1;
        }

        if (checkW > 0 || checkB > 0 || checkM > 0) {
            if (checkW == checkB && checkW == checkM) {
                drink += checkW;
            } else if (checkW <= checkM && checkW <= checkB) {
                drink += checkW;
            } else if (checkM <= checkW && checkM <= checkB) {
                drink += checkM;
            } else {
                drink += checkB;
            }
        }

        return drink;
    }
}
