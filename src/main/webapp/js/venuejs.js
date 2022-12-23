/**
 * 
 */
 function showAnVenue(e){
	const RecordDiv = document.getElementById(e);
	const id = RecordDiv.getAttribute("data-id");
	setCookie("venueID", id);
	const form = document.getElementById("venuesForm");
	form.submit();
}
//sets a cookie
function setCookie(cookieName, cookieValue) {
    const date = new Date();
    date.setTime(date.getTime() + (86400 * 30 * 30));
    let expiry = "expires="+ date.toUTCString();
    document.cookie = cookieName + "=" + cookieValue + ";" + expiry + ";path=/";
    //console.log(expires);
}