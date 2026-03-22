package week2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuestionBank {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/subhamdb";
        String user = "root";
        String password = "local@subham123";


        try (Connection con = DriverManager.getConnection(url, user, password)) {

            con.setAutoCommit(false);

            String sql = "insert into questionBank (question_text, topic) values(?, ?)";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, "What is java?");
                ps.setString(2, "Programming Basics");
                ps.addBatch();

                ps.setString(1, "Is java object oriented?");
                ps.setString(2, "Programming Concepts");
                ps.addBatch();

                int[] results = ps.executeBatch();
                System.out.println("Batch Executed. Inserted " + results.length + " rows.");


                con.commit();
                System.out.println("Transaction committed successfully.");

            }

        } catch (SQLException e) {

            System.out.println("An error occurred during the database operation.");
            e.printStackTrace();
        }
    }
}

/*
 * JDBC try-with-resources pattern:
 * Outer block manages the Connection (con) lifecycle to control the transaction scope (commit/rollback).
 * Inner blocks manage child resources (Statement, PreparedStatement, ResultSet) which close automatically and immediately after their block finishes, freeing resources quickly.
 */

/* package week2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionBank {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/subhamdb";
        String user = "root";
        String password = "local@subham123";

        try {
            // Ensure the JDBC driver is loaded
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            return;
        }

        // Outer try-with-resources manages the Connection lifecycle and transaction scope
        try (Connection con = DriverManager.getConnection(url, user, password)) {

            con.setAutoCommit(false); // Start transaction for DML operations (Insert, Update, Delete)

            // 1. Insertion (from original code, moved to helper method)
            System.out.println("--- Performing Insertion ---");
            insertBatchQuestions(con);

            // 2. Updation
            System.out.println("\n--- Performing Updation ---");
            // Update the topic for the question "What is java?"
            updateQuestionTopic(con, "What is java?", "Java Basics");

            // 3. Deletion (requires a temporary record to show deletion)
            System.out.println("\n--- Performing Deletion Demonstration ---");
            insertSingleQuestion(con, "Temporary question?", "Temp Topic");
            deleteQuestion(con, "Temporary question?");

            con.commit(); // Commit all DML operations if no exception occurred
            System.out.println("\nAll DML transactions committed successfully.");

            // 4. Pagination (Selection does not require commit)
            System.out.println("\n--- Displaying Paginated Results (Limit 2, Offset 0) ---");
            paginateQuestions(con, 2, 0); // Display the first two questions

        } catch (SQLException e) {
            System.out.println("An error occurred during the database operation.");
            e.printStackTrace();
            // The connection closes automatically via try-with-resources.
            // Implicit rollback usually happens for uncommitted transactions.
        }
    }

    /** Helper method for batch insertion. */
//    public static void insertBatchQuestions(Connection con) throws SQLException {
//        String sql = "insert into questionBank (question_text, topic) values(?, ?)";
//        // Inner try-with-resources manages PreparedStatement
//        try (PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setString(1, "What is java?");
//            ps.setString(2, "Programming Basics");
//            ps.addBatch();
//
//            ps.setString(1, "Is java object oriented?");
//            ps.setString(2, "Programming Concepts");
//            ps.addBatch();
//
//            int[] results = ps.executeBatch();
//            System.out.println("Insertion Batch Executed. Inserted " + results.length + " rows.");
//        }
//    }

    /** Helper method for single insertion (used for deletion demo). */
//    public static void insertSingleQuestion(Connection con, String questionText, String topic) throws SQLException {
//        String sql = "insert into questionBank (question_text, topic) values(?, ?)";
//        try (PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setString(1, questionText);
//            ps.setString(2, topic);
//            ps.executeUpdate();
//            System.out.println("Single Insertion Executed.");
//        }
//    }

    /** Helper method for updating records. */
//    public static void updateQuestionTopic(Connection con, String oldQuestionText, String newTopic) throws SQLException {
//        String sql = "UPDATE questionBank SET topic = ? WHERE question_text = ?";
//        try (PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setString(1, newTopic);
//            ps.setString(2, oldQuestionText);
//            int rowsAffected = ps.executeUpdate();
//            System.out.println("Updation Executed. Updated " + rowsAffected + " rows.");
//        }
//    }

    /** Helper method for deleting records. */
//    public static void deleteQuestion(Connection con, String questionText) throws SQLException {
//        String sql = "DELETE FROM questionBank WHERE question_text = ?";
//        try (PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setString(1, questionText);
//            int rowsAffected = ps.executeUpdate();
//            System.out.println("Deletion Executed. Deleted " + rowsAffected + " rows.");
//        }
//    }

    /** Helper method for pagination (selecting records). */
//    public static void paginateQuestions(Connection con, int limit, int offset) throws SQLException {
//        // Uses MySQL-specific LIMIT and OFFSET
//        String sql = "SELECT id, question_text, topic FROM questionBank ORDER BY id LIMIT ? OFFSET ?";
//        try (PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setInt(1, limit);
//            ps.setInt(2, offset);
//
//            // Inner try-with-resources manages ResultSet
//            try (ResultSet rs = ps.executeQuery()) {
//                System.out.println("ID | Question Text | Topic");
//                System.out.println("---------------------------------");
//                while (rs.next()) {
//                    System.out.printf("%d | %s | %s\n", rs.getInt("id"), rs.getString("question_text"), rs.getString("topic"));
//                }
//            }
//        }
//    }
//}


