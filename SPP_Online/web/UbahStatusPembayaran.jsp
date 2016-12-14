<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Sistem Pembayaran Uang Sekolah</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/main.css" />
    </head>
    <body>

        <!-- Page Wrapper -->
        <div id="page-wrapper">

            <!-- Header -->
            <header id="header">
                <h1><a href="HalamanUtama.jsp">Sistem Pembayaran Uang Sekolah</a></h1>
                <nav id="nav">
                    <ul>
                        <li class="special">
                            <a href="#menu" class="menuToggle"><span>Menu</span></a>
                            <div id="menu">
                                <ul>
                                    <li><a href="Admin.jsp">Admin</a></li>
                                    <li><a href="LihatStatus.jsp">Lihat Status</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </nav>
            </header>

            <!-- Main -->
            <article id="main">
                <header>
                    <h2>Ubah Status Pembayaran</h2>
                </header>
                <section class="wrapper style5">
                    <div class="inner">

                        <h3>Masukan Data Pembayaran</h3>
                        <form action="ControlPembayaran" method="post" enctype="multipart/form-data">
                            <input type="file" name="file" size="50" /><br/>
                            <br />                                                                  
                            <input type="submit" value="Unggah" />
                        </form>
                    </div>
                </section>
            </article>

            <!-- Footer -->
            <footer id="footer">
                <ul class="copyright">
                    <li>2016 - SMA Sanata Dharma</li>
                </ul>
            </footer>

        </div>

        <!-- Scripts -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/jquery.scrollex.min.js"></script>
        <script src="assets/js/jquery.scrolly.min.js"></script>
        <script src="assets/js/skel.min.js"></script>
        <script src="assets/js/util.js"></script>
        <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
        <script src="assets/js/main.js"></script>

    </body>
</html>
