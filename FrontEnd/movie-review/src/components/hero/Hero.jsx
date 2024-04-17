import React from 'react'
import './Hero.css';
import Carousel from 'react-material-ui-carousel';
import { Paper } from '@mui/material';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCirclePlay } from '@fortawesome/free-solid-svg-icons';
import { Link, useNavigate } from 'react-router-dom';
import  Button  from 'react-bootstrap/Button';

const Hero = ({ movies }) => {
    if (!movies || !Array.isArray(movies)) {
        return <div>Loading...</div>;
    }

    const navigate = useNavigate();

    function reviews(movieId){
        navigate(`/Reviews/${movieId}`);
    }
    const movieList = Array.isArray(movies[0]) ? movies[0] : movies;
    return (
        <div>
            <Carousel>
                {
                    movieList.map((movie) => {
                        return (
                            <Paper key={movie.imdbId}>
                                <div className='movie-card-container'>
                                    <div className='movie-card' style={{"--img": `url(${movie.backdrops[0]})`}}>
                                        <div className="movie-details">
                                            <div className="movie-poster">
                                                <img src={movie.poster} alt='/' />
                                            </div>
                                            <div>
                                                <h4 className='movie-title'>{movie.title}</h4>
                                            </div>
                                            <div className="movie-buttons-container">
                                                <Link to={`/Trailer/${movie.trailerLink.substring(movie.trailerLink.length - 11)}`}>
                                                    <div className="play-button-icon-container">
                                                        <FontAwesomeIcon className='play-button-icon'
                                                            icon={faCirclePlay}
                                                        />
                                                    </div>
                                                </Link>
                                                <div className="movie-review-button-container">
                                                    <Button variant ="info" onClick={() => reviews(movie.imdbId)} className='review-button'>Reviews</Button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </Paper>
                        )
                    })
                }
            </Carousel>
        </div>
    )
}

export default Hero