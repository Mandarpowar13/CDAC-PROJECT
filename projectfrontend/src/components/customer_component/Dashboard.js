import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router';

export default function Dashboard() {
    const navigate = useNavigate();
    const [trekList, settrekList] = useState([]);



    const { id } = useParams();

    useEffect(() => {
        loadtrek();
    }, []);

    const loadtrek = async () => {
        const result = await axios.get("http://localhost:8080/api/showtreks");
        settrekList(result.data);
        console.log(result.data);
        console.log(id);
    };
    return (
        <div>
            <nav class="bg-dark navbar-dark">
                <div class="container">
                    <a href="" class="navbar-brand"><i class="fas fa-tree mr-2"></i>Forest</a>
                </div>
            </nav>
            <section id="header" class="jumbotron text-center">
                <h1 class="display-3">FOREST</h1>
                <p class="lead">Lorem ipsum, dolor sit amet consectetur adipisicing elit.</p>
                <a href="" class="btn btn-primary">Click</a>
                <a href="" class="btn btn-secondary">Click</a>
            </section>

            <section id="gallery">
                {
                    trekList.map(
                        trek =>
                        <div class="container">
                    <div class="row">
                        <div class=" mb-5">
                            <div class="card">
                                <img src={trek.imgUrl} alt="" class="card-img-top" />
                                <div class="card-body">
                                    <h5 class="card-title">{trek.name}</h5>
                                    <p class="card-text">{trek.price}</p>
                                    <a href= {`/trekdetsils/${trek.id}`} class="btn btn-outline-success btn-sm">More details</a>
                                    <a href="" class="btn btn-outline-danger btn-sm"><i class="far fa-heart"></i></a>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
                    )
                }
                
            </section>

        </div>
    )
}
