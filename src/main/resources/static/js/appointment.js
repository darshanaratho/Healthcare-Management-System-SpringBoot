const BASE = "http://localhost:8080";

// ADD
function addAppointment() {
    const date = document.getElementById("date").value;
    const patientId = document.getElementById("patientId").value;
    const doctorId = document.getElementById("doctorId").value;

    fetch(`${BASE}/appointments`, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            date,
            patient: { id: patientId },
            doctor: { id: doctorId }
        })
    })
    .then(res => res.json())
    .then(() => {
        alert("Appointment Booked");
        loadAppointments();
    });
}

// LOAD
function loadAppointments() {
    fetch(`${BASE}/appointments`)
    .then(res => res.json())
    .then(data => {
        let output = "";
        data.forEach(a => {
            output += `
                <tr>
                    <td>${a.id}</td>
                    <td>${a.date}</td>
                    <td>${a.patient?.name || "-"}</td>
                    <td>${a.doctor?.name || "-"}</td>
                    <td>
                        <button onclick="deleteAppointment(${a.id})">Delete</button>
                    </td>
                </tr>
            `;
        });
        document.getElementById("appointmentTable").innerHTML = output;
    });
}

// UPDATE
function updateAppointment() {
    const id = document.getElementById("updateId").value;
    const date = document.getElementById("updateDate").value;
    const patientId = document.getElementById("updatePatientId").value;
    const doctorId = document.getElementById("updateDoctorId").value;

    fetch(`${BASE}/appointments/${id}`, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            date,
            patient: { id: patientId },
            doctor: { id: doctorId }
        })
    })
    .then(res => res.json())
    .then(() => {
        alert("Appointment Updated");
        loadAppointments();
    });
}

// DELETE
function deleteAppointment(id) {
    fetch(`${BASE}/appointments/${id}`, { method: "DELETE" })
    .then(() => {
        alert("Deleted");
        loadAppointments();
    });
}

// AUTO LOAD
window.onload = loadAppointments;