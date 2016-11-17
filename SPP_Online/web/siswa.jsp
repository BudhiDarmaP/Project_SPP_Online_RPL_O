<!DOCTYPE HTML>
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
											<li><a href="siswa.jsp">Siswa</a></li>
											<li><a href="bank.jsp">Bank</a></li>
										</ul>
									</div>
								</li>
							</ul>
						</nav>
					</header>

				<!-- Main -->
					<article id="main">
						<header>
							<h2>Siswa</h2>
						</header>
						<section class="wrapper style5">
							<div class="inner">

								<h3>Masukan data pembayaran</h3>
								
									<form action="VerifikasiPembayaran" method="post">
										<div class="row uniform">
											<div class="6u 12u$(xsmall)">
												<input type="text" name="nis" placeholder="NIS" />
											</div>
											<div class="6u 12u$(xsmall)">
												<input type="text" name="nama" placeholder="Nama" />
											</div>
											<div class="6u 12u$(xsmall)">
												<div class="select-wrapper">
													<select name="jenis" >
														<option value="">- Jenis Pembayaran -</option>
														<option value="SPP">SPP</option>
														<option value="UK">Uang Kesehatan</option>
														<option value="UB">Uang Buku</option>
													</select>
												</div>
											</div>
											
                                                                                    
											<div class="6u$ 12u$">
												<input type="text" name="jumlah" placeholder="Jumlah Pembayaran" />
											</div>
                                                                                        
                                                                                        <div class="6u 12u$(xsmall)">
												<input type="text" name="tanggal" placeholder="Tanggal Pembayaran" />
                                                                                                <label>Format: DD-MM-YYYY Contoh: 25-12-2016</label>
                                                                                        </div>
											<div class="12u$">
												<ul class="actions">
													<li><input type="submit" value="Send" class="special" /></li>
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
