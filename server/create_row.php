<?php
 
/*
 * Following code will create a new product row
 * All product details are read from HTTP Post Request
 */
 
// array for JSON response
$response = array();
 
// check for required fields
if (isset($_POST['author']) && isset($_POST['status'])) {
 
    $author = $_POST['author'];
    $status = $_POST['status'];
    
 
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    $db = new DB_CONNECT();
 
    // mysql inserting a new row
    $result = mysql_query("INSERT INTO statuses(author, status) VALUES('$author', '$status')");
    $last_id = mysql_insert_id();

    // check if row inserted or not
    if ($result) {
        // successfully inserted into database
        $response["success"] = 1;
        $response["message"] = $status;
        $response["author"] = $author;
        $response["id"] = $last_id;
        // echoing JSON response
        echo json_encode($response);
    } else {
        // failed to insert row
        $response["success"] = 0;
        $response["message"] = "Oops! An error occurred.";
        $response["author"] = "unknown";
        $response["id"] = -1;
        // echoing JSON response
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
    $response["author"] = "unknown";
    $response["id"] = -1;
    // echoing JSON response
    echo json_encode($response);
}
?>
