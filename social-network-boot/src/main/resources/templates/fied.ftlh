<#ftl encoding="utf-8">
<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
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

    <title>Fied</title>

</head>
<body style="background-color: rgba(217,219,215,0.3);">
<br>

<br><br>

<div class="row">

    <div class="col">

    </div>

    <div class="col">
        <h1>News</h1>
    </div>

    <div class="col">

    </div>

</div>

<br>

<br>

<#list posts as post>

    <div class="row">

        <div class="col"></div>

        <div class="col">

            <div class="card text-white bg-primary mb-3" style="width: 18rem;">
                <div class="row">
                    <div class="col"></div>
                    <div class="col"></div>
                    <div class="col"></div>
                    <div class="col"></div>
                    <div class="col-sm col-sm-push-1">
                        <a href="/page/${post.pageId}/post/${post.postId}/delete" uk-close></a>
                    </div>
                </div>
                <div class="uk-card-default uk-card-large card-body">
                    <h5 class="card-title">${post.authorFirstName} ${post.authorSecondName}</h5>
                    <p class="card-text">${post.date}</p>
                    <p class="card-text">${post.text}</p>
                    <a href="/like?postId=${post.postId}&page=profile?id=${id}" class="uk-icon-button" uk-icon="heart"></a>
                    <span>${post.countOfLikes}</span>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <button type="button" id="leave_comment" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                        Leave comment
                    </button>
                    <span>
                        <a href="/post/${post.postId}/comments/1"><p>Show comments</p></a>
                    </span>
                </div>
            </div>

        </div>

        <div class="col"></div>

    </div>

    <hr style="color: black"><br>

    <div class="row">
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title" id="exampleModalLabel">Leave your comment</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="/comment">
                            <input type="hidden" name="postId" value="${post.postId}"/>
                            <input type="text" id="comment" name="text" style="font-size: large"
                                   class="intput-comment">
                            <input type="submit" class="btn btn-primary" id="submit" value="Leave comment">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</#list>

</body>
</html>