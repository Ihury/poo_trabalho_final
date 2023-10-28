import restaurant.exceptions.InvalidIdException;
import restaurant.items.Beverage;
import restaurant.items.Dessert;
import restaurant.items.Ingredient;
import restaurant.items.MainCourse;
import restaurant.menus.DessertsMenu;
import restaurant.menus.IngredientsMenu;
import restaurant.menus.ItemsMenu;
import restaurant.menus.MainMenu;
import restaurant.menus.Menu;
import restaurant.menus.MainCourseMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Ingredient> ingredients = new ArrayList<>();
    private static final ArrayList<MainCourse> mainCourses = new ArrayList<>();
    private static final ArrayList<Dessert> desserts = new ArrayList<>();
    private static final ArrayList<Beverage> beverages = new ArrayList<>();
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        startMainMenu();
    }

    private static void startMainMenu() {
        String opt;
        do {
            MainMenu.showMain();
            opt = sc.nextLine();

            switch (opt) {
                case "1":
                    startIngredientsMenu();
                    break;
                case "2":
                    startItensMenu();
                    break;
                case "v":
                    startMainMenu();
                    break;
                case "s":
                    leave();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    waitEnter();
            }
        } while (!opt.equals("s"));
    }

    private static void startIngredientsMenu() {
        String opt;
        do {
            IngredientsMenu.showMain();
            opt = sc.nextLine();

            switch (opt) {
                case "1":
                    showIngredients();
                    break;
                case "2":
                    addIngredient();
                    break;
                case "3":
                    removeIngredient();
                    break;
                case "v":
                    startMainMenu();
                    break;
                case "s":
                    leave();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    waitEnter();
            }
        } while (!opt.equals("s"));
    }

    private static void showIngredients() {
        String opt;
        do {
            IngredientsMenu.showIngredients(ingredients);
            opt = sc.nextLine();

            switch (opt) {
                case "v":
                    startIngredientsMenu();
                    break;
                case "s":
                    leave();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    waitEnter();
            }
        } while (!opt.equals("s"));
    }

    private static void addIngredient() {
        Menu.clearConsole();
        System.out.print("Informe o nome do ingrediente: ");
        String name = sc.nextLine();
        ingredients.add(new Ingredient(name));
        waitEnter();
        startIngredientsMenu();
    }

    private static void removeIngredient() {
        String opt;
        do {
            IngredientsMenu.showRemoveIngredient(ingredients);
            opt = sc.nextLine();

            switch (opt) {
                case "v":
                    startIngredientsMenu();
                    break;
                case "s":
                    leave();
                    break;
                default:
                    try {
                        int ingredientIndex = Integer.parseInt(opt);
                        if (ingredientIndex > 0 && ingredientIndex <= ingredients.size()) {
                            ingredients.remove(ingredientIndex - 1);
                        }
                        startIngredientsMenu();
                    } catch (NumberFormatException e) {
                        System.out.println("Opção inválida!");
                        waitEnter();
                    }
            }
        } while (!opt.equals("s"));
    }

    private static void startItensMenu() {
        String opt;
        do {
            ItemsMenu.showMain();
            opt = sc.nextLine();

            switch (opt) {
                case "1":
                    startMainCoursesMenu();
                    break;
                case "2":
                    startDessertsMenu();
                    break;
                case "3":
                    // startDrinksMenu();
                    break;
                case "v":
                    startMainMenu();
                    break;
                case "s":
                    leave();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    waitEnter();
            }
        } while (!opt.equals("s"));
    }

    private static void startMainCoursesMenu() {
        String opt;
        do {
            MainCourseMenu.showMain();
            opt = sc.nextLine();

            switch (opt) {
                case "1":
                    showMainCourses();
                    break;
                case "2":
                    addMainCourse();
                    break;
                case "3":
                    removeMainCourse();
                    break;
                case "v":
                    startItensMenu();
                    break;
                case "s":
                    leave();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    waitEnter();
            }
        } while (!opt.equals("s"));
    }

    private static void showMainCourses() {
        String opt;
        do {
            MainCourseMenu.showMainCourses(mainCourses);
            opt = sc.nextLine();

            switch (opt) {
                case "v":
                    startMainCoursesMenu();
                    break;
                case "s":
                    leave();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    waitEnter();
            }
        } while (!opt.equals("s"));
    }

    private static void addMainCourse() {
        Menu.clearConsole();
        try {
            System.out.print("Informe o ID do prato: ");
            String id = sc.nextLine();
            System.out.print("Informe o nome do prato: ");
            String name = sc.nextLine();
            System.out.print("Informe o preço do prato: ");
            double price = Double.parseDouble(sc.nextLine());
            System.out.print("Informe o preço de custo do prato: ");
            double costPrice = Double.parseDouble(sc.nextLine());
            System.out.print("Informe a descrição do prato: ");
            String description = sc.nextLine();
            System.out.print("Informe o tempo de preparo do prato: ");
            String preparationTime = sc.nextLine();

            MainCourse mainCourse = new MainCourse(id, name, price, costPrice, description, preparationTime);
            mainCourses.add(mainCourse);
            System.out.println("Prato adicionado!");
            waitEnter();
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
            waitEnter();
        } catch (IllegalArgumentException e) {
            System.out.println("Preço inválido!");
            waitEnter();
        }
    }

    private static void removeMainCourse() {
        String opt;
        do {
            MainCourseMenu.showRemoveMainCourse(mainCourses);
            opt = sc.nextLine();

            switch (opt) {
                case "v":
                    startMainCoursesMenu();
                    break;
                case "s":
                    leave();
                    break;
                default:
                    try {
                        int mainCourseIndex = Integer.parseInt(opt);
                        if (mainCourseIndex > 0 && mainCourseIndex <= mainCourses.size()) {
                            mainCourses.remove(mainCourseIndex - 1);
                        }
                        startMainCoursesMenu();
                    } catch (NumberFormatException e) {
                        System.out.println("Opção inválida!");
                        waitEnter();
                    }
            }
        } while (!opt.equals("s"));
    }

    private static void startDessertsMenu() {
        String opt;
        do {
            DessertsMenu.showMain();
            opt = sc.nextLine();

            switch (opt) {
                case "1":
                    showDesserts();
                    break;
                case "2":
                    addDessert();
                    break;
                case "3":
                    removeDessert();
                    break;
                case "v":
                    startItensMenu();
                    break;
                case "s":
                    leave();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    waitEnter();
            }
        } while (!opt.equals("s"));
    }

    private static void showDesserts() {
        String opt;
        do {
            DessertsMenu.showMainCourses(desserts);
            opt = sc.nextLine();

            switch (opt) {
                case "v":
                    startDessertsMenu();
                    break;
                case "s":
                    leave();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    waitEnter();
            }
        } while (!opt.equals("s"));
    }

    private static void addDessert() {
        Menu.clearConsole();
        try {
            System.out.print("Informe o ID da sobremesa: ");
            String id = sc.nextLine();
            System.out.print("Informe o nome da sobremesa: ");
            String name = sc.nextLine();
            System.out.print("Informe o preço da sobremesa: ");
            double price = Double.parseDouble(sc.nextLine());
            System.out.print("Informe o preço de custo da sobremesa: ");
            double costPrice = Double.parseDouble(sc.nextLine());
            System.out.print("Informe a descrição da sobremesa: ");
            String description = sc.nextLine();
            System.out.print("Informe o tempo de preparo da sobremesa: ");
            String preparationTime = sc.nextLine();
            System.out.print("Informe a quantidade de calorias da sobremesa: ");
            double calorieCount = Double.parseDouble(sc.nextLine());
            Dessert dessert = new Dessert(id, name, price, costPrice, description, preparationTime, calorieCount);
            desserts.add(dessert);
            System.out.println("Sobremesa adicionada!");
            waitEnter();
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
            waitEnter();
        } catch (IllegalArgumentException e) {
            System.out.println("Preço inválido!");
            waitEnter();
        }
    }

    private static void removeDessert() {
        String opt;
        do {
            DessertsMenu.showRemoveMainCourse(desserts);
            opt = sc.nextLine();

            switch (opt) {
                case "v":
                    startDessertsMenu();
                    break;
                case "s":
                    leave();
                    break;
                default:
                    try {
                        int dessertIndex = Integer.parseInt(opt);
                        if (dessertIndex > 0 && dessertIndex <= desserts.size()) {
                            desserts.remove(dessertIndex - 1);
                        }
                        startDessertsMenu();
                    } catch (NumberFormatException e) {
                        System.out.println("Opção inválida!");
                        waitEnter();
                    }
            }
        } while (!opt.equals("s"));
    }

    private static void waitEnter() {
        System.out.println("Pressione ENTER para continuar...");
        sc.nextLine();
    }

    private static void leave() {
        System.exit(0);
    }
}