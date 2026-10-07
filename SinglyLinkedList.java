import java.util.Scanner;

public class SinglyLinkedList {

    static class Node {
        int rollNo;
        String name;
        Node next;

        Node(int rollNo, String name) {
            this.rollNo = rollNo;
            this.name = name;
            this.next = null;
        }
    }

    Node head = null;

    Node find(int rollNo) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    void insert(int rollNo, String name) {
        if (find(rollNo) != null) {
            System.out.println("Roll number " + rollNo + " is already registered!");
            return;
        }
        Node newNode = new Node(rollNo, name);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Student enrolled successfully.");
    }

    void delete(int rollNo) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student withdrawn successfully.");
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student not found!");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student withdrawn successfully.");
        }
    }

    void search(int rollNo) {
        Node found = find(rollNo);
        if (found == null) {
            System.out.println("Student not found!");
        } else {
            System.out.println("Found -> Roll No: " + found.rollNo + ", Name: " + found.name);
        }
    }

    void update(int rollNo, String newName) {
        Node found = find(rollNo);
        if (found == null) {
            System.out.println("Student not found!");
        } else {
            found.name = newName;
            System.out.println("Record updated successfully.");
        }
    }

    void display() {
        if (head == null) {
            System.out.println("No students registered.");
            return;
        }
        System.out.println("Registered students:");
        Node temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        int choice;

        do {
            System.out.println("\n--- Student Registration (Singly Linked List) ---");
            System.out.println("1. Insert (Enroll)\n2. Delete (Withdraw)\n3. Search\n4. Update\n5. Display\n6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number: ");
                    int r = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    list.insert(r, sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter roll number to withdraw: ");
                    list.delete(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    list.search(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter roll number to update: ");
                    int u = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    list.update(u, sc.nextLine());
                    break;
                case 5:
                    list.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
        sc.close();
    }
}