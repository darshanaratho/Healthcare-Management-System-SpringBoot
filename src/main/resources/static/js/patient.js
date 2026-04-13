const BASE = "http://localhost:8080";

// ADD
function addPatient() {
    const name = document.getElementById("name").value;
    const age = document.getElementById("age").value;

    fetch(`${BASE}/patients`, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({ name, age })
    })
    .then(res => res.json())
    .then(() => {
        alert("Patient Added");
        loadPatients();
    });
}

// LOAD
function loadPatients() {
    fetch(`${BASE}/patients`)
    .then(res => res.json())
    .then(data => {
        let output = "";
        data.forEach(p => {
            output += `
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.age}</td>
                    <td>
                        <button onclick="deletePatient(${p.id})">Delete</button>
                    </td>
                </tr>
            `;
        });
        document.getElementById("patientTable").innerHTML = output;
    });
}

// UPDATE
function updatePatient() {
    const id = document.getElementById("updateId").value;
    const name = document.getElementById("updateName").value;
    const age = document.getElementById("updateAge").value;

    fetch(`${BASE}/patients/${id}`, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({ name, age })
    })
    .then(res => res.json())
    .then(() => {
        alert("Patient Updated");
        loadPatients();
    });
}

// DELETE
function deletePatient(id) {
    fetch(`${BASE}/patients/${id}`, { method: "DELETE" })
    .then(() => {
        alert("Deleted");
        loadPatients();
    });
}

// AUTO LOAD
window.onload = loadPatients;