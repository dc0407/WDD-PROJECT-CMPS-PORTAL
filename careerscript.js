const generateCVButton = document.getElementById('generate-cv');
generateCVButton.addEventListener('click', generateCV);

function generateCV() {
	const name = document.getElementById('name').value;
	const email = document.getElementById('email').value;
	const phone = document.getElementById('phone').value;
	const address = document.getElementById('address').value;
	const degree = document.getElementById('degree').value;
	const university = document.getElementById('university').value;
	const graduationDate = document.getElementById('graduation-date').value;
	const jobTitle = document.getElementById('job-title').value;
	const employer = document.getElementById('employer').value;
	const startDate = document.getElementById('start-date').value;
	const endDate = document.getElementById('end-date').value;
	const jobDescription = document.getElementById('job-description').value;

	const cvTemplate = `
		<h2>${name}</h2>
		<p>${email} | ${phone} | ${address}</p>

		<h3>Education</h3>
		<p><strong>${degree}</strong>, ${university}</p>
		<p>Graduated: ${graduationDate}</p>

		<h3>Work Experience</h3>
		<p><strong>${jobTitle}</strong>, ${employer}</p>
		<p>${startDate} - ${endDate}</p>
		<p>${jobDescription}</p>
	`;

	const cvOutput = document.createElement('div');
	cvOutput.innerHTML = cvTemplate;

	document.body.appendChild(cvOutput);
}

