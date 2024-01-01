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
                {invoices && invoices.length > 0 ? (
                    <table className="table border shadow">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Invoice Number</th>
                            <th scope="col">Seller Name</th>
                            <th scope="col">Buyer Name</th>
                        </tr>
                        </thead>
                        <tbody>

                        {
                            invoices.map((invoice, index) => (
                                <tr>
                                    <th scope="row" key={index}>
                                        {index + 1}
                                    </th>
                                    <td>{invoice.invoiceNumber}</td>
                                    <td>{invoice.sellerName}</td>
                                    <td>{invoice.buyerName}</td>
                                </tr>
                            ))
                        }
                        </tbody>
                    </table>
                ) : (
                    <h2>There is no invoice in database. You can add some after clicking Add Invoice button.</h2>
                )}
            </div>
        </div>
    )
}