<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Categories</title>
<link rel="stylesheet" href="css/Books.css">
<style>
    /* Back button */
    .back-btn {
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    padding: 10px 20px;
    cursor: pointer;
    margin-top: 3px; /* Adjust as needed */
    display: block;
    width: fit-content;
    margin-left: auto;
    margin-right: auto;
    position: relative;
}
    
    
</style>
</head>
<body>

<div class="container">
  <div class="frame">
    <h1 class="category-heading">Categories</h1>
     <div class="buttons">
      <a href="fantasytable.jsp?username=<%= request.getParameter("username") %>" class="category-btn">Fantasy</a>
      
      <a href="fictiontable.jsp?username=<%= request.getParameter("username") %>" class="category-btn">Fiction</a>
      <a href="biographytable.jsp?username=<%= request.getParameter("username") %>" class="category-btn">Biography</a>
      <a href="View_All.jsp?username=<%= request.getParameter("username") %>" class="category-btn">View All</a>
    </div>
    <a href="UserPage.jsp" class="back-btn">Back</a>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="script.js"></script>

</body>
</html>
