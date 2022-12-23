/**
 *All apppointments  
 */

/*
Ztores the selected appointment's ID and pass it to a cookie  
later
Redirect to an appointment page on label click */
const startTimeElement = document.getElementById("StartTime");
startTimeElement.setAttribute("min", "09:00");
startTimeElement.setAttribute("max", "18:00");

const endTimeElement = document.getElementById("EndTime");
endTimeElement.setAttribute("min", "09:00");
endTimeElement.setAttribute("max", "09:00");

const dateElement = document.getElementById("EndTime");
var today = new Date();
var dd = today.getDate();
var mm = today.getMonth() + 1; //January is 0!
var yyyy = today.getFullYear();

if (dd < 10) {
   dd = '0' + dd;
}

if (mm < 10) {
   mm = '0' + mm;
} 
    
today = yyyy + '-' + mm + '-' + dd;
startTimeElement.setAttribute("min", today);

function showAnAppointment(e){
	const RecordDiv = document.getElementById(e);
	const id = RecordDiv.getAttribute("data-id");
	setCookie("appointmentID", id);
	const form = document.getElementById("eventAppointmentsForm");
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