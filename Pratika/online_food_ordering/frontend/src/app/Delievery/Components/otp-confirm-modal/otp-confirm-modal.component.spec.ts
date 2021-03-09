import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { OtpConfirmModalComponent } from './otp-confirm-modal.component';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

describe('OtpConfirmModalComponent', () => {
  let component: OtpConfirmModalComponent;
  let fixture: ComponentFixture<OtpConfirmModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OtpConfirmModalComponent ],
      providers: [NgbActiveModal],
      imports: [HttpClientTestingModule]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OtpConfirmModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
