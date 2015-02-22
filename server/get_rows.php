<?php
 
/*
 * Following code will get single product details
 * A product is identified by product id (pid)
 */
 
// array for JSON response
$response = array();
 
// include db connect class
require_once __DIR__ . '/db_connect.php';
 
// connecting to db
$db = new DB_CONNECT();
 
// check for post data
if (isset($_GET["_id"])) {
    $_id = intval($_GET['_id']);

    // get a product from products table
    $result = mysql_query("SELECT *FROM statuses WHERE _id > $_id");
}

 
// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // products node
    $response["convos"] = array();
 
    while ($row = mysql_fetch_array($result)) {
        // temp user array
        $convo = array();
        $convo["_id"] = $row["_id"];
        $convo["author"] = $row["author"];
        $convo["status"] = $row["status"];
        $convo["time"] = $row["time"];
 
        // push single product into final response array
        array_push($response["convos"], $convo);
    }
    // success
    $response["success"] = 1;
 
    // echoing JSON response
    echo json_encode($response);
} else {
    // no products found
    $response["success"] = 0;
    $response["message"] = "No convos found";
 
    // echo no users JSON
    echo json_encode($response);
}
?>
