import React, {useEffect, useState} from "react";
import axios from "axios";

export default function Home() {

    const [clients, setClients] = useState([]);

    useEffect(() => {
        loadClients();
    }, []);

    const loadClients = async() => {
        const result = axios.get("http://localhost:8080/clients");
        setClients(result.data);
    }

    return (
        <div className="container">
            <div className="py-4">
                {clients && clients.length > 0 ? (
                    <table className="table border shadow">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Client Full Name</th>
                            <th scope="col">NIP</th>
                        </tr>
                        </thead>
                        <tbody>

                        {
                            clients.map((client, index) => (
                                <tr>
                                    <th scope="row" key={index}>
                                        {index + 1}
                                    </th>
                                    <td>{client.fullName}</td>
                                    <td>{client.NIP}</td>
                                    <td>
                                        <button className="btn btn-primary mx-2">View</button>
                                        <button className="btn btn-outline-primary mx-2">Edit</button>
                                        <button className="btn btn-danger mx-2">Delete</button>
                                    </td>
                                </tr>
                            ))
                        }
                        </tbody>
                    </table>
                ) : (
                    <h2>There is no client in database. You can add some after clicking Add Client button.</h2>
                )}
            </div>
        </div>
    )
}