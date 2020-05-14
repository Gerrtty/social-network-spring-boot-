<!DOCTYPE html>
<html>
<head>

    <style>

        #map {
            height: 400px;
            width: 100%;
        }
    </style>

    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>

</head>
<body>
<h3>My Google Maps Demo</h3>
<!--The div element for the map -->
<div id="map"></div>

<script>

    var l1;
    var l2;

    // Initialize and add the map
    function initMap() {

        var kazan = {lat: 55, lng: 49};

        var map = new google.maps.Map(
            document.getElementById('map'), {zoom: 4, center: kazan});

        no = "no";

        var l = ${mapDto.lat};

        if(l.valueOf().toString() != "no") {
            var marker1 = new google.maps.Marker({position: {lat: ${mapDto.lat}, lng: ${mapDto.lon}}, map: map});
        }

        <#--if(${mapDto.lat} != null) {-->
        <#--    var marker = new google.maps.Marker({position: {lat: ${mapDto.lat}, lng: ${mapDto.lon}, map: map});-->
        <#--}-->

        google.maps.event.addListener(map, "click", function(event) {
            // get lat/lon of click
            var clickLat = event.latLng.lat();
            var clickLon = event.latLng.lng();

            l1 = clickLat;
            l2 = clickLon;

            console.log(clickLat);
            console.log(clickLon);

            $('#lat').val(clickLat);
            $('#lon').val(clickLon);

            var marker = new google.maps.Marker({position: {lat: clickLat, lng: clickLon}, map: map});

        });
    }
</script>

<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDGvdemYhZQdXc4TZb1iJiEgXughfbd04E&callback=initMap">
</script>

<form method="post" action="/photo/${photoId}/map">

    <input type="hidden" id="lat" name="lat" value="">
    <input type="hidden" id="lon" name="lon" value="">
    <input type="submit" value="Set location">

</form>

</body>
</html>