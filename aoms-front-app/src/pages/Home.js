import React, {useEffect, useState} from "react";
import axios from "axios";

export default function Home() {

    const [invoices, setInvoices] = useState([]);

    useEffect(() => {
        loadInvoices();
    }, []);

    const loadInvoices=async() => {
        const result = axios.get("http://localhost:8080/invoices");
        setInvoices(result.data);
    }

    return (
        <div className="container">
            <div className="py-4">
                <table className="table border shadow">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">First</th>
                        <th scope="col">Last</th>
                        <th scope="col">Handle</th>
                    </tr>
                    </thead>
                    <tbody>

                    {
                        invoices.map((invoice, index) => (
                            <tr>
                                <th scope="row" key={index}>
                                    {index + 1}
                                </th>
                                {/* FIXME dokończyć specyfikowanie kolumn według tego co jest w encji Invoice */}
                                <td>{invoice.invoiceNumber}</td>
                            </tr>
                        ))
                    }
                    </tbody>
                </table>
            </div>
        </div>
    )
}