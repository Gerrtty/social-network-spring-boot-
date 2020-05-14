<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/css/uikit/uikit.min.css" >

    <script src="/js/uikit.min.js"></script>
    <script src="/js/uikit-icons.min.js"></script>

    <!-- JS code -->
    <script src="https://code.jquery.com/jquery-3.1.1.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js">
    </script>

    <title>Comments</title>
</head>
<body>

<header>
    <div class="navbar navbar-dark bg-dark shadow-sm"></div>
</header>

<br><br>

<#list comments as comment>

    <div class="row">

        <div class="col"></div>

        <div class="col">

            <article class="uk-comment uk-comment-primary">
                <header class="uk-comment-header uk-grid-medium uk-flex-middle" uk-grid>
<#--                    <div class="uk-width-auto">-->
<#--                        <img class="uk-comment-avatar" src="images/avatar.jpg" width="80" height="80" alt="">-->
<#--                    </div>-->
                    <div class="uk-width-expand">
                        <h4 class="uk-comment-title uk-margin-remove">
                            <a class="uk-link-reset" href="/profile?id=${comment.authorCommentId}">
                                ${comment.firstName} ${comment.secondName}</a>
                        </h4>
<#--                        <ul class="uk-comment-meta uk-subnav uk-subnav-divider uk-margin-remove-top">-->
<#--                            <li><a href="#">12 days ago</a></li>-->
<#--                            <li><a href="#">Reply</a></li>-->
<#--                        </ul>-->
                    </div>
                </header>
                <div class="uk-comment-body">
                    <p>${comment.text}</p>
                </div>
            </article>
        </div>

        <div class="col"></div>

    </div>

    <hr class="uk-divider-small">

    <br>

</#list>

</body>
</html>