import React, {Component} from 'react';

class Company extends Component {
    render() {
        return (
            <>

                <div className="company d-flex flex-column">

                    <p className="title">About of company</p>

                    <div className="info d-flex justify-content-between align-items-center flex-wrap">

                        <div className="review d-flex flex-column justify-content-center align-items-center">
                            <h1>4,7</h1>
                            <div className="stars d-flex">
                                <i className="bi bi-star-fill"/>
                                <i className="bi bi-star-fill"/>
                                <i className="bi bi-star-fill"/>
                                <i className="bi bi-star-fill"/>
                                <i className="bi bi-star-fill"/>
                            </div>
                            <p>46 product ratings</p>

                        </div>

                        <div className="photo align-items-center cursor-pointer">

                            <div className="image">

                                <img src="/images/pro9.png" alt=""/>
                            </div>

                            <p>Veysel Oglu Group</p>

                        </div>


                        <div className="little-info">
                            <p>Email: Space.y@inbox.ru</p>
                            <p>Phone: +994 70 518 40 97</p>
                            <p>Country/City: Azerbaijan Gakh</p>
                            <p>Adress: Sagdan 6 ci ev</p>
                            <p>Year Established: 2000</p>
                            <p>Employees: 97</p>
                            <p>Business type: Electronics</p>
                            <p>Visit Company Site: Azerbaijan.com</p>

                        </div>


                    </div>

                    <hr/>

                    <p className="title">Description</p>

                    <div className="description">

                        <p>
                            iPhone 12 ve iPhone 12 mini.
                            H??z??n?? anlatmaya kelimeler yeti??emez.
                            Bir ak??ll?? telefondaki en h??zl?? ??ip olan A14 Bionic. Kenarlara kadar uzanan OLED ekran.
                            D????melere kar???? d??rt kat daha iyi performans sunan Ceramic Shield.
                            Ve art??k t??m kameralarda yer alan Gece modu. Muhte??em boyutlardaki iki farkl?? modeliyle
                            t??m bu ??zelliklere ev sahipli??i yapan
                            iPhone 12 ile tan??????n.Gece modu art??k hem Geni?? kamerada
                            hem de Ultra Geni?? kamerada. Ve ??imdi lo?? ??????kta ola??an??st?? g??zellikte kareler yakalama
                            konusunda hi?? olmad?????? kadar yetenekli. ??stelik yeni Geni?? kamera
                            y??zde 27 daha fazla ??????k yakalayabiliyor. B??ylece ister g??nd??z ayd??nl??????nda ??ekim
                            yap??n isterseniz ay ??????????nda, foto??raflar??n??z daha ??nce hi?? g??rmedi??iniz ayr??nt??lara ve
                            renklere ev sahipli??i yap??yor.AR teknolojisini kullanarak her a????dan g??r??nt??leyin.
                            Bu sayfay?? iPhone veya iPad???inizde Safari ile a????n.Apple???dan sat??n alman??n avantajlar??.
                            Yeni bir iPhone sat??n alma konusunda sorular??n??z m?? var? Yard??ma haz??r??z.
                        </p>

                    </div>

                </div>

            </>
        );
    }
}

export default Company;