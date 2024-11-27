<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="/css/style2.css">
  <title>User Profile</title>
</head>

<body>
  <div class="container">
    <h1>User Profile</h1>
    <div class="profile">
      <img src="profile_pic.jpg" alt="Profile Picture" style="width: 100px; height: 100px;">
      <h2>${userData.clientName}</h2>
    </div>
    <div class="info">
      <h3>Personal Information</h3>
      <p><strong>Email:</strong> ${userData.clientEmail}</p>
      <p><strong>Phone:</strong> ${userData.clientMobileNumber}</p>
      <p><strong>Role:</strong> ${userData.clientRole.roleName}</p>
      <p><strong>JWT:</strong> ${userData.clientRefreshToken}</p>
    </div>
    <div class="info user-stats">
      <h3>User Statistics</h3>
      <p>Total Purchases: 10</p>
      <p>Average Purchase Value: $25.50</p>
    </div>
    <div class="info seller-stats">
      <h3>Seller Statistics</h3>
      <p>Total Sales: 5</p>
      <p>Average Sales Value: $50.25</p>
    </div>
  </div>

  <div class="footer">
    <p>&copy; 2022 YourCompany. All rights reserved.</p>
  </div>
</body>

</html>