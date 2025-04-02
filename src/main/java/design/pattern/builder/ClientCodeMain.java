package design.pattern.builder;

public class ClientCodeMain {
    public static void main(String[] args) {
        // Input parameters
        String baseQuery = "SELECT * FROM employees";
        String filterColumn = "department";
        String filterValue = "HR";
        String orderByColumn = "salary";
        String orderByDirection = "DESC";

        // Use QueryBuilder to prepare the query
        QueryBuilder queryBuilder = new QueryBuilder(baseQuery);

        String query = queryBuilder
                .addFilter(filterColumn, "=", filterValue)
                .addOrderBy(orderByColumn, orderByDirection)
                .build();

        System.out.println("Generated Query: " + query);
    }
}
