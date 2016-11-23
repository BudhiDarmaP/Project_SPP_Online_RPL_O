<html>
	<head>
		<title>Sistem Pembayaran Uang Sekolah</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
	</head>
	<body>

		<!-- Page Wrapper -->
			<div id="page-wrapper">

				<!-- Header -->
					<header id="header">
						<h1><a href="index.jsp">Sistem Pembayaran Uang Sekolah</a></h1>
						<nav id="nav">
							<ul>
								<li class="special">
									<a href="#menu" class="menuToggle"><span>Menu</span></a>
									<div id="menu">
										<ul>
											<li><a href="index.jsp">Home</a></li>
											<li><a href="LihatStatus.jsp">Lihat Status</a></li>
											<li><a href="Admin.jsp">Admin</a></li>
										</ul>
									</div>
								</li>
							</ul>
						</nav>
					</header>

				<!-- Main -->
					<article id="main">
						<header>
							<h2>Buat Tagihan</h2>
						</header>
						<section class="wrapper style5">
							<div class="inner">

								<h3>Masukkan Tagihan</h3>
								
									<form action="ControlTagihan" method="post">
										<div class="row uniform">
											<div class="6u 12u$(xsmall)">
                                                                                                <select name="bulan" >
                                                                                                    <option value="">- Bulan tagihan -</option>
                                                                                                    <option value="01">Januari</option>
                                                                                                    <option value="02">Februari</option>
                                                                                                    <option value="03">Maret</option>
                                                                                                    <option value="04">April</option>
                                                                                                    <option value="05">Mei</option>
                                                                                                    <option value="06">Juni</option>
                                                                                                    <option value="07">Juli</option>
                                                                                                    <option value="08">Agustus</option>
                                                                                                    <option value="09">September</option>
                                                                                                    <option value="10">Oktober</option>
                                                                                                    <option value="11">November</option>
                                                                                                    <option value="12">Desember</option>
                                                                                                </select>
												<input type="text" name="tagihan" placeholder="Jumlah Tagihan" />
                                                                                                </div>
													<li><input type="submit" value="Buat" class="special" /></li>
													<li><input type="reset" value="Reset" /></li>
												</ul>
											</div>
										</div>
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
