import React from 'react';
import { useEffect, useRef } from 'react';
import api from '../../api/axiosConfig';
import { useParams } from 'react-router-dom';
import { Col, Row, Container } from 'react-bootstrap';
import ReviewForm from '../reviewForm/ReviewForm';
/**
 * @param {Object} props
 * @param {Function} props.getMovieData
 * @param {Object} props.movie
 * @param {Array<{ body: string }>} props.reviews
 * @param {Function} props.setReviews
 */
const Reviews = ({getMovieData, movie, reviews, setReviews}) => {

    const revText = useRef();
    let params = useParams();
    const movieId = params.movieId;
    useEffect(() =>{
        getMovieData(movieId);
    },[])

    const addReview = async (e) => {
        e.preventDefault();

        const rev = revText.current;
        try{

            const response = await api.post("/api/v1/movies/reviews", {reviewBody:rev.value,imdbId:movieId});
    
            const updatedReviews = Array.isArray(reviews) ? [...reviews, { body: rev.value }] : [{ body: rev.value }];
    
            rev.value = "";
    
            setReviews(updatedReviews);
        }
        catch(err){
            console.log(err);
        }

    }
  return (
    <Container>
        <Row>
            <Col><h3>Reviews</h3></Col>
        </Row>
        <Row className='mt-2'>
            <Col>
                <img src={movie?.poster} alt="/" />
            </Col>
            <Col>
                {
                    <>
                        <Row>
                            <Col>
                                <ReviewForm handleSubmit={addReview} revText={revText} labelText="Write a Review?" />
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <hr />
                            </Col>
                        </Row>
                    </>
                }
                {
                    (reviews?.length > 0) && reviews.map((review, index) => {
                        return(
                            <React.Fragment key={index}>
                                <Row>
                                    <Col>{review.body}</Col>
                                </Row>
                                <Row>
                            <Col>
                                <hr />
                            </Col>
                        </Row>
                            </React.Fragment>
                        )
                    })
                }
            </Col>
        </Row>
    </Container>
  )
}

export default Reviews