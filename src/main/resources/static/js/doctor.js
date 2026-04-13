const BASE = "http://localhost:8080";

// ADD
function addDoctor() {
    const name = document.getElementById("name").value;
    const spec = document.getElementById("spec").value;

    fetch(`${BASE}/doctors`, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({ name, specialization: spec })
    })
    .then(res => res.json())
    .then(() => {
        alert("Doctor Added");
        loadDoctors();
    });
}

// LOAD
function loadDoctors() {
    fetch(`${BASE}/doctors`)
    .then(res => res.json())
    .then(data => {
        let output = "";
        data.forEach(d => {
            output += `
                <tr>
                    <td>${d.id}</td>
                    <td>${d.name}</td>
                    <td>${d.specialization}</td>
                    <td>
                        <button onclick="deleteDoctor(${d.id})">Delete</button>
                    </td>
                </tr>
            `;
        });
        document.getElementById("doctorTable").innerHTML = output;
    });
}

// UPDATE
function updateDoctor() {
    const id = document.getElementById("updateId").value;
    const name = document.getElementById("updateName").value;
    const spec = document.getElementById("updateSpec").value;

    fetch(`${BASE}/doctors/${id}`, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({ name, specialization: spec })
    })
    .then(res => res.json())
    .then(() => {
        alert("Doctor Updated");
        loadDoctors();
    });
}

// DELETE
function deleteDoctor(id) {
    fetch(`${BASE}/doctors/${id}`, { method: "DELETE" })
    .then(() => {
        alert("Deleted");
        loadDoctors();
    });
}

// AUTO LOAD
window.onload = loadDoctors;