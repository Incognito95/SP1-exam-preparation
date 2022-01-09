import React, { useState, useEffect } from "react";
import facade from "../ApiFacade";

const SpecificBoat = () => {
    const [boatList, setbBoatList] = useState([]);
    useEffect(() => {
        facade.fetchData("boat")
            .then(data => {
                setbBoatList(data);
            })
    }, []);

    const [ownerList, setOwnerList] = useState([]);
    useEffect(() => {
        facade.fetchData("owner")
            .then(data => {
                setOwnerList(data);
            })
    }, []);


    const [query, setQuery] = useState("");

    return (
        <div className="container mt-5">
            <h2>Owners Of Specific Boat</h2>
            <div class="btn-group float-end">
                <button class="btn btn-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Select Boat
                </button>
                <ul className="dropdown-menu">
                    {
                        boatList.map((boat, index) => (
                            <li className="dropdown-item">{boat.name}</li>
                        ))
                    }
                </ul>
            </div>
            <table className="table mt-4">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Phone</th>
                </tr>
                </thead>
                <tbody>
                {
                    ownerList.map((owner, index) => (
                        <tr>
                            <td>{owner.id}</td>
                            <td>{owner.name}</td>
                            <td>{owner.address}</td>
                            <td>{owner.phone}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )
}



export default SpecificBoat;