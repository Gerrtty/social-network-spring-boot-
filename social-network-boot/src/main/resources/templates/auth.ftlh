<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Authorization</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link href="/css/auth.css" rel="stylesheet">

</head>

<body>

<div class="container">

    <form class="form-signin" role="form" action="auth/process" method="post">

        <h2 class="form-signin-heading">Sign in</h2>

        <input type="email" name="email" class="form-control" placeholder="Email..." required autofocus>
        <input type="password" name="password" class="form-control" placeholder="Password..." required>

        <input class="btn btn-lg btn-dark btn-block" type="submit" value="Sign in">

    </form>

</div>

</body>
</html>