<#--<!doctype html>-->
<#--<html lang="en" xmlns="http://www.w3.org/1999/html">-->
<#--<#import "spring.ftl" as spring />-->
<#--<head>-->
<#--    <meta charset="UTF-8">-->
<#--    <meta name="viewport"-->
<#--          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">-->
<#--    <meta http-equiv="X-UA-Compatible" content="ie=edge">-->

<#--    <title>Registration</title>-->

<#--    <!-- Bootstrap core CSS &ndash;&gt;-->
<#--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">-->

<#--    <!-- Custom styles for this template &ndash;&gt;-->
<#--    <link href="/css/reg.css" rel="stylesheet">-->

<#--    <title>Registration</title>-->
<#--</head>-->

<#--<style>-->
<#--    .error {-->
<#--        color: rgba(219,8,24,0.97);-->
<#--    }-->
<#--</style>-->

<#--<body>-->

<#--<div class="row">-->

<#--    <div class="col">-->

<#--    </div>-->
<#--    <div class="col">-->
<#--        <h2 class="heading">Registration</h2>-->
<#--        <br>-->
<#--        <@spring.bind "registrationDto"/>-->
<#--        <form class="form-signup" action="reg" method="post">-->

<#--            First name: <@spring.formInput "registrationDto.firstName"/> </br> </br>-->
<#--            Second name: <@spring.formInput "registrationDto.secondName"/> </br> </br>-->
<#--            Email: <@spring.formInput "registrationDto.email"/>-->
<#--            </br> </br>-->
<#--            <@spring.showErrors "<br>", "error"/>-->
<#--            Password: <@spring.formInput "registrationDto.password">-->
<#--            </br> </br>-->
<#--            <@spring.showErrors "<br>", "error"/>-->
<#--            <br><br>-->
<#--            </@spring.formInput>-->
<#--            <input class="btn btn-lg btn-dark btn-block" type="submit" name="submit" id="submit" value="Sign up" />-->
<#--        </form>-->
<#--    </div>-->
<#--    <div class="col">-->

<#--    </div>-->

<#--</div>-->

<#--</body>-->
<#--</html>-->

<!doctype html>
<html lang="en">
<#import "spring.ftl" as spring />
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <!-- Custom styles for this template -->
        <link href="/css/reg.css" rel="stylesheet">

    <title>Registration</title>
</head>
<style>
    .error {
        color: #ff0000;
    }
</style>
<body>

<br>
<header>

    <div class="row">

        <div class="col"></div>
        <div class="col"></div>
        <div class="col">
            <h2>Registration</h2>

        </div>
        <div class="col">
        </div>
        <div class="col"></div>

    </div>

</header>

<br>

<div class="row">

    <div class="col"></div>
    <div class="col">

        <div>
            <@spring.bind "registrationDto"/>
            <form class="form-signup" action="/reg" method="post">

                First name: <br>
                <@spring.formInput "registrationDto.firstName"/>
                <br>Second name: <br>
                <@spring.formInput "registrationDto.secondName"/>
                <br>Email: <br>
                <@spring.formInput "registrationDto.email"/>
                <@spring.showErrors "<br><br>", "error"/>
<#--                <@spring.showErrors "<br>"/>-->
                <br>Password: <br>
                <@spring.formPasswordInput "registrationDto.password"/>
                <@spring.showErrors "<br>","error"/>
                <br><br>
                <input class="btn btn-lg btn-dark btn-block" type="submit" name="submit" id="submit" value="Sign up">
            </form>
        </div>

    </div>

    <div class="col"></div>

</div>

</body>
</html>
